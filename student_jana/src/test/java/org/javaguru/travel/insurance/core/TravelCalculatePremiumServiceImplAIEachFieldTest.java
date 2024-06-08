/*package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelCalculatePremiumServiceImplAIEachFieldTest {
    private DateTimeService dateTimeService = new DateTimeService();

    @Test
    public void testPersonFirstName() {
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(dateTimeService);
        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 27);
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 24);
        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name", "surname", toDate,fromDate);
        request.setPersonFirstName("John");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    public void testPersonLastName() {
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(dateTimeService);
        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 27);
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 24);
        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name", "surname", toDate,fromDate);
        request.setPersonLastName("Doe");
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    public void testAgreementDateFrom() {
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(dateTimeService);
        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 27);
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 24);
        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name", "surname", toDate,fromDate);
        request.setAgreementDateFrom(fromDate);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void testAgreementDateTo() {
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(dateTimeService);
        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 27);
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 24);
        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name", "surname", toDate,fromDate);
        request.setAgreementDateTo(toDate);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void testCalculateDaysBetweenAgreementDates() {
        TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(dateTimeService);
        LocalDate agreementDateFrom = LocalDate.of(2024, 5, 27);
        LocalDate agreementDateTo = LocalDate.of(2024, 5, 24);
        Date fromDate = Date.from(agreementDateFrom.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(agreementDateTo.atStartOfDay(ZoneId.systemDefault()).toInstant());
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name", "surname", toDate,fromDate);
        request.setAgreementDateFrom(fromDate);
        request.setAgreementDateTo(toDate);
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        BigDecimal expectedDays = new BigDecimal(3);
        assertEquals(expectedDays,response.getAgreementPrice());
    }
}*/