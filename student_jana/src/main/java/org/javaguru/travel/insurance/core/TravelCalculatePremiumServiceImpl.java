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
        Date agreementDateFrom = calculateAgreementDateFrom();
        Date agreementDateTo = calculateAgreementDateTo();
        response.setAgreementDateFrom(agreementDateFrom);
        response.setAgreementDateTo(agreementDateTo);
        BigDecimal daysBetween=calculateDaysBetweenAgreementDateToAndAgreementDateFrom();
        response.setAgreementPrice(new BigDecimal(String.valueOf(daysBetween)));
        return response;
    }

        private Date calculateAgreementDateFrom(){
            LocalDate agreementDateFrom = LocalDate.of(2024, 5, 24);
            return Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        private Date calculateAgreementDateTo(){
            LocalDate agreementDateTo = LocalDate.of(2024, 5, 27);
            return Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    private BigDecimal calculateDaysBetweenAgreementDateToAndAgreementDateFrom(){
        long diff = calculateAgreementDateTo().getTime() - calculateAgreementDateFrom().getTime();
        var daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return (new BigDecimal(daysBetween));
    }
}
