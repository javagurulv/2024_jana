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
        System.out.println("Result: " + result.toString());
        System.out.println("Expected: " + expected.toString());

    }
    @Test
    public void testFirstNameIsNotEmpty() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date agreementDateFrom = dateFormat.parse("2024-05-24");
        Date agreementDateTo = dateFormat.parse("2024-05-27");
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("name","surname", agreementDateFrom,agreementDateTo);
        List<ValidationError> result=validator.validate(request);
        List<ValidationError> expected = new ArrayList<>();
        System.out.println("Result: " + result.toString());
        System.out.println("Expected: " + expected.toString());
    }

}
