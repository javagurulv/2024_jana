package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {

    @Test
    public void testCalculatePremium() {
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Name");
        request.setPersonLastName("Surname");
        request.setAgreementDateTo(new Date());
        request.setAgreementDateFrom(new Date());

        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(),request.getPersonFirstName());
        assertEquals(response.getPersonLastName(),request.getPersonLastName());
        assertEquals(response.getAgreementDateTo(),request.getAgreementDateTo());
        assertEquals(response.getAgreementDateFrom(),request.getAgreementDateFrom());

        System.out.println(response.getPersonFirstName());
        System.out.println(request.getPersonFirstName());

        System.out.println(response.getPersonLastName());
        System.out.println(request.getPersonLastName());

        System.out.println(response.getAgreementDateTo());
        System.out.println(request.getAgreementDateTo());

        System.out.println(response.getAgreementDateFrom());
        System.out.println(request.getAgreementDateFrom());

    }

}