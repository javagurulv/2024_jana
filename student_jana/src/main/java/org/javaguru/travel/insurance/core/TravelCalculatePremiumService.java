package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.javaguru.travel.insurance.rest.ValidationError;

import java.util.List;

public interface TravelCalculatePremiumService {


    TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request);
}
