package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void testGetAgreementDateTo() throws ParseException {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDateTo = dateFormat.parse("2024-05-27");
        Date responseDateTo = response.getAgreementDateTo();
        assertEquals("expected"+expectedDateTo,"actual"+responseDateTo);

    }

    @Test
    public void testGetAgreementDateFrom() throws ParseException {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = dateFormat.parse("2024-05-24");
        assertEquals(response.getAgreementDateFrom(),expectedDate);
    }

    @Test
    public void testGetAgreementDatePrice() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest()
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        BigDecimal expectedAgreementPrice = new BigDecimal(3);
        assertEquals(expectedAgreementPrice,response.getAgreementPrice());
        System.out.println(response.getAgreementPrice());
    }

}