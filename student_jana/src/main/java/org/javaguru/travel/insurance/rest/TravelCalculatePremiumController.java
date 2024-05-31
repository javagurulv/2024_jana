package org.javaguru.travel.insurance.rest;

import org.javaguru.travel.insurance.core.TravelCalculatePremiumService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RestController
@RequestMapping("/insurance/travel")
public class TravelCalculatePremiumController {

	private final TravelCalculatePremiumService calculatePremiumService;

	TravelCalculatePremiumController(TravelCalculatePremiumService calculatePremiumService) {
		this.calculatePremiumService = calculatePremiumService;
	}

	@PostMapping(path = "/",
			consumes = "application/json",
			produces = "application/json")
	public TravelCalculatePremiumResponse calculatePremium(@RequestBody TravelCalculatePremiumRequest request) {

		Date agreementDateFrom = request.getAgreementDateFrom();
		Date agreementDateTo = request.getAgreementDateTo();

		long daysBetween = ChronoUnit.DAYS.between(agreementDateFrom.toInstant(), agreementDateTo.toInstant());
		BigDecimal agreementPrice = BigDecimal.valueOf(daysBetween);
		request.setAgreementPrice(agreementPrice);

		return calculatePremiumService.calculatePremium(request);

	}

}