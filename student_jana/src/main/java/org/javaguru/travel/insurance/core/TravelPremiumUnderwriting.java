package org.javaguru.travel.insurance.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)

public class TravelPremiumUnderwriting {
    private DateTimeService dateTimeService;

    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
       var daysBetween=dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom(request.getAgreementDateFrom(),request.getAgreementDateTo());
        return new BigDecimal(String.valueOf(daysBetween));
    }
}
