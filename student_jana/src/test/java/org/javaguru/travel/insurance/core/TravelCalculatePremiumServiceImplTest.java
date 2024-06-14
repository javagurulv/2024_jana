package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class TravelCalculatePremiumServiceImplTest {
    @Mock private DateTimeService dateTimeService;
    @Mock private TravelPremiumUnderwriting travelPremiumUnderwriting;

    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;

    private TravelCalculatePremiumRequest request;
    @Mock private TravelCalculatePremiumRequestValidator requestValidator;

    @BeforeEach
    public void setUp() throws ParseException {
        request = createRequestWithAllFields();
        when(travelPremiumUnderwriting.calculatePremium(request)).thenReturn(BigDecimal.valueOf(3));
    }

    private TravelCalculatePremiumRequest createRequestWithAllFields() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateFrom,agreementDateTo);
        when(requestValidator.validate(request)).thenReturn(List.of());
        return request;
    }

    @Test
    public void testPersonFirstName() throws ParseException {
        TravelCalculatePremiumResponse response=service.calculatePremium(request);
        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
    }

    @Test
    public void testPersonLastName() throws ParseException {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(response.getPersonLastName(), request.getPersonLastName());
    }

    @Test
    public void testGetAgreementDateTo() throws ParseException {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void testGetAgreementDateFrom() throws ParseException {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void testGetAgreementDatePrice() throws ParseException {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        BigDecimal expectedAgreementPrice = new BigDecimal(3);
        assertEquals(expectedAgreementPrice, response.getAgreementPrice());
    }
}
