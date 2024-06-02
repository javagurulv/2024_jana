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
    public void testPersonFirstName() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Name", "Surname",agreementDateFrom,agreementDateTo);
        request.setPersonFirstName("Name");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
    }

    @Test
    public void testPersonLastName() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Name" ,"Surname",agreementDateFrom,agreementDateTo);
        request.setPersonLastName("Surname");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonLastName(), request.getPersonLastName());
    }
   @Test
    public void testGetAgreementDateTo() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name", "surname", agreementDateFrom, agreementDateTo);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(agreementDateTo, response.getAgreementDateTo());
    }

    @Test
    public void testGetAgreementDateFrom() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname",agreementDateFrom,agreementDateTo);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getAgreementDateFrom(), agreementDateFrom);
    }

    @Test
    public void testGetAgreementDatePrice() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        BigDecimal expectedAgreementPrice = new BigDecimal(3);
        assertEquals(expectedAgreementPrice, response.getAgreementPrice());
        System.out.println(response.getAgreementPrice());
    }
}

