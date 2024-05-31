package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.ZoneId;
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
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 27);
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        request.setAgreementDateTo(toDate);

        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 24);
        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        request.setAgreementDateFrom(fromDate);

        // Вызываем метод calculatePremium
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Проверяем, что свойства объекта response установлены правильно
        assertEquals("John", response.getPersonFirstName());
        assertEquals("Doe", response.getPersonLastName());
        assertEquals(fromDate, response.getAgreementDateFrom());
        assertEquals(toDate, response.getAgreementDateTo());
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
