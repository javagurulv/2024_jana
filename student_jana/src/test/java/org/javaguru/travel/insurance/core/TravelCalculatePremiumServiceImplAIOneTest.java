package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TravelCalculatePremiumServiceImplAIOneTest {

    @Test
    public void testCalculatePremium_WithValidRequest_ShouldSetAllResponseProperties() {
        // Создаем сервис и запрос
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Doe");
        Date dateFrom = new Date();
        Date dateTo = new Date();
        request.setAgreementDateFrom(dateFrom);
        request.setAgreementDateTo(dateTo);

        // Вызываем метод calculatePremium
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Проверяем, что свойства объекта response установлены правильно
        assertEquals("John", response.getPersonFirstName());
        assertEquals("Doe", response.getPersonLastName());
        assertEquals(dateFrom, response.getAgreementDateFrom());
        assertEquals(dateTo, response.getAgreementDateTo());
    }

    @Test
    public void testCalculatePremium_WithNullRequest_ShouldThrowNullPointerException() {
        // Создаем сервис
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();

        // Проверяем, что вызывая метод calculatePremium с null, выбрасывается NullPointerException
        assertThrows(NullPointerException.class, () -> {
            service.calculatePremium(null);
        });
    }
}
