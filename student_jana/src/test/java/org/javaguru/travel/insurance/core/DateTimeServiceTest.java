package org.javaguru.travel.insurance.core;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeServiceTest {
    private DateTimeService dateTimeService = new DateTimeService();


    @Test
    public void testGetAgreementDatePrice1() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom, agreementDateTo);
        BigDecimal expected = new BigDecimal(3);
        assertEquals(expected,dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo));
    }
    @Test
    public void testGetAgreementDatePrice2() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-24");
        dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom, agreementDateTo);
        BigDecimal expected = new BigDecimal(0);
        assertEquals(expected,dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo));
    }

}
