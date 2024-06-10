package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.ValidationError;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelCalculatePremiumRequestValidatorTest {
    private TravelCalculatePremiumRequestValidator validator= new TravelCalculatePremiumRequestValidator();
    @Test
    public void testFirstNameIsEmpty() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("","surname", agreementDateFrom,agreementDateTo);
        List<ValidationError> result=validator.validate(request);
        List<ValidationError> expected = new ArrayList<>();
        expected.add(new ValidationError("personFirstName", "Must not be empty!"));
        assertEquals(expected.toString(),result.toString());

    }
    @Test
    public void testFirstNameIsNotEmpty() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateFrom,agreementDateTo);
        List<ValidationError> result=validator.validate(request);
        List<ValidationError> expected = new ArrayList<>();
        assertEquals(expected.toString(),result.toString());
    }
    @Test
    public void testLastNameIsEmpty() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","", agreementDateFrom,agreementDateTo);
        List<ValidationError> result=validator.validate(request);
        List<ValidationError> expected = new ArrayList<>();
        expected.add(new ValidationError("personLastName", "Must not be empty!"));
        assertEquals(expected.toString(),result.toString());
    }
    @Test
    public void testLastNameIsNotEmpty() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateFrom,agreementDateTo);
        List<ValidationError> result=validator.validate(request);
        List<ValidationError> expected = new ArrayList<>();
        assertEquals(expected.toString(),result.toString());
    }
    @Test
    public void testDateFromIsNull() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname",agreementDateTo ,null);
        List<ValidationError> result=validator.validate(request);
        List<ValidationError> expected = new ArrayList<>();
        expected.add(new ValidationError("dateFrom", "Must not be empty!"));
        assertEquals(expected.toString(),result.toString());
    }
}
