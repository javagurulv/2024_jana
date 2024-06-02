package org.javaguru.travel.insurance.core;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//Для того чтобы воспользоваться классом DateTimeService в классе
//TravelCalculatePremiumServiceImpl "повесьте" на новый класс
//аннотацию @Component (по аналогии с TravelCalculatePremiumServiceImpl).
@Component
public class DateTimeService {
    private Date agreementDateFrom;
    private Date agreementDateTo;

    public Date getAgreementDateFrom() {
        return agreementDateFrom;
    }

    public void setAgreementDateFrom(Date agreementDateFrom) {
        this.agreementDateFrom = agreementDateFrom;
    }
    public Date getAgreementDateTo() {
        return agreementDateTo;
    }

    public void setAgreementDateTo(Date agreementDateTo) {
        this.agreementDateTo = agreementDateTo;
    }
    public BigDecimal calculateDaysBetweenAgreementDateToAndAgreementDateFrom(){
        long diff = agreementDateTo.getTime() - agreementDateFrom.getTime();
        var daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return new BigDecimal(daysBetween);
    }
}
