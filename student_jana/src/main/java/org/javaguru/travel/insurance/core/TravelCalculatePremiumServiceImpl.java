package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    //Для того чтобы воспользоваться новым классом в
    //TravelCalculatePremiumServiceImpl просто создайте конструктор
    //принимающий его в качестве параметра и сохраняющего в свойство класса
    private DateTimeService dateTimeService;

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();

        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());

        dateTimeService.setAgreementDateTo(request.getAgreementDateTo());
        dateTimeService.setAgreementDateFrom(request.getAgreementDateFrom());
        //присваиваю значения из request, чтобы не были равны нулю
        response.setAgreementDateFrom(dateTimeService.getAgreementDateFrom());
        response.setAgreementDateTo(dateTimeService.getAgreementDateTo());
        // вызываю метод из класса DateTimeService
        BigDecimal daysBetween=dateTimeService.calculateDaysBetweenAgreementDateToAndAgreementDateFrom();
        response.setAgreementPrice(new BigDecimal(String.valueOf(daysBetween)));
        return response;

    }
}
