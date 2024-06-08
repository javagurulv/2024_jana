/*package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TravelCalculatePremiumServiceImplAIOneTest {
    private DateTimeService dateTimeService = new DateTimeService();

    @Test
    public void testCalculatePremium_WithValidRequest_ShouldSetAllResponseProperties() {
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(dateTimeService);
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Doe");
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 27);
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        request.setAgreementDateTo(toDate);
        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 24);
        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        request.setAgreementDateFrom(fromDate);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals("John", response.getPersonFirstName());
        assertEquals("Doe", response.getPersonLastName());
        assertEquals(fromDate, response.getAgreementDateFrom());
        assertEquals(toDate, response.getAgreementDateTo());
    }

    @Test
    public void testCalculatePremium_WithNullRequest_ShouldThrowNullPointerException() {
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(dateTimeService);
        assertThrows(NullPointerException.class, () -> {
            service.calculatePremium(null);
        });
    }
}*/
