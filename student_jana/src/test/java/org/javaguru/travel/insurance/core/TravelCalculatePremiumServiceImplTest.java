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
    private DateTimeService dateTimeService = new DateTimeService();
    private TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(dateTimeService);

    @Test
    public void testPersonFirstName() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Name", "Surname");
        request.setPersonFirstName("Name");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
    }

    @Test
    public void testPersonLastName() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Name" ,"Surname");
        request.setPersonLastName("Surname");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonLastName(), request.getPersonLastName());
    }
   @Test
    public void testGetAgreementDateTo() throws ParseException {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        request.setAgreementDateTo(dateFormat.parse("2024-05-27"));
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        Date responseDateTo = response.getAgreementDateTo();
        assertEquals(dateFormat.parse("2024-05-27"), responseDateTo);
    }

    @Test
    public void testGetAgreementDateFrom() throws ParseException {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = dateFormat.parse("2024-05-24");
        assertEquals(response.getAgreementDateFrom(), expectedDate);
    }

    @Test
    public void testGetAgreementDatePrice() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        BigDecimal expectedAgreementPrice = new BigDecimal(3);
        assertEquals(expectedAgreementPrice, response.getAgreementPrice());
        System.out.println(response.getAgreementPrice());
    }
}

