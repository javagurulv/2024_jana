
package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {

    @Mock
    private DateTimeService dateTimeService;
    @Mock private TravelCalculatePremiumRequestValidator requestValidator;

    @InjectMocks
    private TravelCalculatePremiumServiceImpl travelCalculatePremiumServiceImpl;

    @Test
    public void testPersonFirstName() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response=travelCalculatePremiumServiceImpl.calculatePremium(request);
        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
    }

    @Test
    public void testPersonLastName() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = travelCalculatePremiumServiceImpl.calculatePremium(request);
        assertEquals(response.getPersonLastName(), request.getPersonLastName());
    }

    @Test
    public void testGetAgreementDateTo() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = travelCalculatePremiumServiceImpl.calculatePremium(request);
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void testGetAgreementDateFrom() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response =  travelCalculatePremiumServiceImpl.calculatePremium(request);
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void testGetAgreementDatePrice() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        when(requestValidator.validate(request)).thenReturn(List.of());
        TravelCalculatePremiumResponse response = travelCalculatePremiumServiceImpl.calculatePremium(request);
        BigDecimal expectedAgreementPrice = new BigDecimal(3);
        assertEquals(expectedAgreementPrice, response.getAgreementPrice());
    }
}
