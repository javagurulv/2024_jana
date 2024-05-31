package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 24);
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 27);
        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        response.setAgreementDateFrom(fromDate);
        response.setAgreementDateTo(toDate);
        long diff=request.getAgreementDateTo().getTime() - request.getAgreementDateFrom().getTime();
        var daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        response.setAgreementPrice(new BigDecimal(daysBetween));
        return response;
    }
}
