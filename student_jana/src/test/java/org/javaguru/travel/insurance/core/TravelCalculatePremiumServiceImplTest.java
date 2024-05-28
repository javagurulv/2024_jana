package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

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
        System.out.println("First name test finished");
        System.out.println(response.getPersonFirstName());
        System.out.println(request.getPersonFirstName());

    }
    @Test
    public void testPersonLastName() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonLastName("Surname");
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        assertEquals(response.getPersonLastName(),request.getPersonLastName());
        System.out.println("Last name test finished");
        System.out.println(response.getPersonLastName());
        System.out.println(request.getPersonLastName());
    }
    @Test
    public void testgetAgreementDateTo() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setAgreementDateTo(new Date());
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        assertEquals(response.getAgreementDateTo(),request.getAgreementDateTo());
        System.out.println("Date To test finished");
        System.out.println(response.getAgreementDateTo());
        System.out.println(request.getAgreementDateTo());
    }
    @Test
    public void testgetAgreementDateFrom() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setAgreementDateFrom(new Date());
        TravelCalculatePremiumResponse response =service.calculatePremium(request);
        assertEquals(response.getAgreementDateFrom(),request.getAgreementDateFrom());
        System.out.println("Date From test finished");
        System.out.println(response.getAgreementDateFrom());
        System.out.println(request.getAgreementDateFrom());
    }

}