package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelCalculatePremiumServiceImplAIEachFieldTest {

    @Test
    public void testPersonFirstName() {
        // Создаем сервис и запрос
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");

        // Вызываем метод calculatePremium
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Проверяем, что свойство personFirstName установлено правильно
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    public void testPersonLastName() {
        // Создаем сервис и запрос
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonLastName("Doe");

        // Вызываем метод calculatePremium
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Проверяем, что свойство personLastName установлено правильно
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    public void testAgreementDateFrom() {
        // Создаем сервис и запрос
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        Date dateFrom = new Date();
        request.setAgreementDateFrom(dateFrom);

        // Вызываем метод calculatePremium
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Проверяем, что свойство agreementDateFrom установлено правильно
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void testAgreementDateTo() {
        // Создаем сервис и запрос
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        Date dateTo = new Date();
        request.setAgreementDateTo(dateTo);

        // Вызываем метод calculatePremium
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Проверяем, что свойство agreementDateTo установлено правильно
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }
}
