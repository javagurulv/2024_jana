package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {
    private TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();

    @Test
    public void testPersonFirstName() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Name");
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(),request.getPersonFirstName());


    }
    @Test
    public void testPersonLastName() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonLastName("Surname");
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        assertEquals(response.getPersonLastName(),request.getPersonLastName());

    }
    @Test
    public void testgetAgreementDateTo() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setAgreementDateTo(new Date());
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        assertEquals(response.getAgreementDateTo(),request.getAgreementDateTo());

    }
    @Test
    public void testgetAgreementDateFrom() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setAgreementDateFrom(new Date());
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        assertEquals(response.getAgreementDateFrom(),request.getAgreementDateFrom());

    }
    @Test
    public void testgetAgreementDatePrice() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();

        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 24);
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 27);

        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());

        request.setAgreementDateFrom(fromDate);
        request.setAgreementDateTo(toDate);

        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        System.out.println(response.getAgreementPrice());

        assertEquals(response.getAgreementPrice(),request.getAgreementPrice());

    }

}