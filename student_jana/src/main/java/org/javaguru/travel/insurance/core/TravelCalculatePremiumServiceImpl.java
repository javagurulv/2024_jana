package org.javaguru.travel.insurance.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.javaguru.travel.insurance.rest.ValidationError;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)

class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    private final DateTimeService dateTimeService;
    private final TravelCalculatePremiumRequestValidator requestValidator;


    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = requestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new TravelCalculatePremiumResponse(errors);
        }
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateTo(request.getAgreementDateTo());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        BigDecimal daysBetween = dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(request.getAgreementDateTo(),request.getAgreementDateFrom());
        response.setAgreementPrice(new BigDecimal(String.valueOf(daysBetween)));
        return response;
    }
}
