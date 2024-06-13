package org.javaguru.travel.insurance.core;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class DateTimeService {

    public BigDecimal calculateDaysBetweenAgreementDateToAndAgreementDateFrom(Date agreementDateFrom, Date agreementDateTo) {
        long diff = agreementDateTo.getTime() - agreementDateFrom.getTime();
        var daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return new BigDecimal(daysBetween);
    }
}
