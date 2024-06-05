
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {
    //DateTimeService mockDateTimeService = Mockito.mock(DateTimeService.class);
    //private TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl(mockDateTimeService);
    @Mock
    private DateTimeService dateTimeService;
    @InjectMocks
    private TravelCalculatePremiumServiceImpl travelCalculatePremiumServiceImpl;

    @Test
    public void testPersonFirstName() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        //when(mockDateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom, agreementDateTo))
        //.thenReturn(new BigDecimal(3));
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        TravelCalculatePremiumResponse response=travelCalculatePremiumServiceImpl.calculatePremium(request);
        //= service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
    }

    @Test
    public void testPersonLastName() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        //when(mockDateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom, agreementDateTo))
        //.thenReturn(new BigDecimal(3));
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        TravelCalculatePremiumResponse response = travelCalculatePremiumServiceImpl.calculatePremium(request);
        //= service.calculatePremium(request);
        assertEquals(response.getPersonLastName(), request.getPersonLastName());
    }

    @Test
    public void testGetAgreementDateTo() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        //when(mockDateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom, agreementDateTo))
        //.thenReturn(new BigDecimal(3));
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        TravelCalculatePremiumResponse response = travelCalculatePremiumServiceImpl.calculatePremium(request);
        //= service.calculatePremium(request);
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void testGetAgreementDateFrom() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        //when(mockDateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom, agreementDateTo))
        //.thenReturn(new BigDecimal(3));
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        TravelCalculatePremiumResponse response =  travelCalculatePremiumServiceImpl.calculatePremium(request);
        //= service.calculatePremium(request);
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void testGetAgreementDatePrice() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        //when(mockDateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom, agreementDateTo))
        //.thenReturn(new BigDecimal(3));
        when(dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(agreementDateFrom,agreementDateTo)).thenReturn(new BigDecimal(3));
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateTo,agreementDateFrom);
        TravelCalculatePremiumResponse response = travelCalculatePremiumServiceImpl.calculatePremium(request);
        //= service.calculatePremium(request);
        BigDecimal expectedAgreementPrice = new BigDecimal(3);
        assertEquals(expectedAgreementPrice, response.getAgreementPrice());
    }
}
