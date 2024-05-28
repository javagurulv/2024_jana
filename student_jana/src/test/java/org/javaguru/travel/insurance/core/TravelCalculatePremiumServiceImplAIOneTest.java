package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelCalculatePremiumServiceImplAIOneTest {

    @Test
    public void testCalculatePremium_WithValidRequest_ShouldSetResponseProperties() {
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
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void testCalculatePremium_WithNullRequest_ShouldReturnResponseWithNullProperties() {
        // Создаем сервис
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();

        // Вызываем метод calculatePremium с null в качестве аргумента
        TravelCalculatePremiumResponse response = service.calculatePremium(null);

        // Проверяем, что свойства объекта response равны null
        assertEquals(null, response.getPersonFirstName());
        assertEquals(null, response.getPersonLastName());
        assertEquals(null, response.getAgreementDateFrom());
        assertEquals(null, response.getAgreementDateTo());
    }
}
