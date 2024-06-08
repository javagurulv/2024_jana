package org.javaguru.travel.insurance.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TravelCalculatePremiumResponse extends ValidationError{

    private String personFirstName;
    private String personLastName;
    private Date agreementDateFrom;
    private Date agreementDateTo;
    private BigDecimal agreementPrice;
    private List<ValidationError> errors;

    public TravelCalculatePremiumResponse(List<ValidationError> errors) {
        this.errors = errors;
    }
}

