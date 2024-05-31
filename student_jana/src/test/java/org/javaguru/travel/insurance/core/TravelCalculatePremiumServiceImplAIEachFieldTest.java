package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.ZoneId;
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
        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 24);
        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        request.setAgreementDateFrom(fromDate);

        // Вызываем метод calculatePremium
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Проверяем, что свойство agreementDateFrom установлено правильно
        assertEquals(fromDate, response.getAgreementDateFrom());
    }

    @Test
    public void testAgreementDateTo() {
        // Создаем сервис и запрос
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 27);
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        request.setAgreementDateTo(toDate);

        // Вызываем метод calculatePremium
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Проверяем, что свойство agreementDateTo установлено правильно
        assertEquals(toDate, response.getAgreementDateTo());
    }
}
