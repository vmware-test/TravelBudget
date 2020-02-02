package org.demo.traveller.controller;

import org.demo.traveller.model.Budget;
import org.demo.traveller.service.product.IBudgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/traveller")
public class TravellerController {
	
	private static final Logger logger = LoggerFactory.getLogger(TravellerController.class);

	
	@Autowired
	@Qualifier("BudgetService")
	private IBudgetService budgetService;
		

	@RequestMapping(value = "/budget", method = RequestMethod.GET)
	public ResponseEntity<Budget> getBudget(@RequestParam String country,  @RequestParam String currency, @RequestParam int totalAmount, @RequestParam int amountPerCountry) throws Exception {
		logger.debug("Budget calculation request: country"+ country + " currency=" + currency + " totalAmount=" + totalAmount + " amountPerCountry=" + amountPerCountry);
		try {
			Budget budget = budgetService.calculateBudget(country, currency, totalAmount, amountPerCountry);
			return new ResponseEntity<Budget>(budget, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
		
	}
}
	
	