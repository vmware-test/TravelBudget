package org.demo.traveller.service.product;

import org.demo.traveller.dao.budget.IBudgetDao;
import org.demo.traveller.model.Budget;
import org.demo.traveller.service.util.RestClient;
import org.demo.traveller.vo.Country;
import org.demo.traveller.vo.Rate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;

@Service("BudgetService")
public class BudgeteService implements IBudgetService {
	private static final Logger logger = LoggerFactory.getLogger(BudgeteService.class);

	@Autowired
	protected IBudgetDao usageDao;

	@Override
	public Budget calculateBudget(String country, String currency, int totalAmount, int amountPerCountry) throws Exception {
		logger.debug("Calculate budget");
		// validate  
		if(amountPerCountry<=0 || totalAmount <=0 || amountPerCountry >=totalAmount ) {
			throw new Exception("Invalid amount");
		}
		if(!isValidInput(country) || !isValidInput(currency)) {
			throw new Exception("Invalid input for country/currency");
		}
		CountryCode cc = CountryCode.getByCode(country.toUpperCase());
		CurrencyCode currencyCode = CurrencyCode.getByCodeIgnoreCase(currency);
		if(cc == null || currencyCode == null) {	
			// country/currency not parsable - drop request
			throw new Exception("Country/Currency not found");
		}
		
		// find neighbors
		Country[] countries = RestClient.getNeighbors(cc.getAlpha2());
		// calculate amounts
		int calculatedAmountPerCountry = totalAmount / countries.length;
		if(calculatedAmountPerCountry<amountPerCountry) {
			throw new Exception("Not enough total amount");
		}
		
		int rounds = calculatedAmountPerCountry / amountPerCountry;
		int leftover = totalAmount - rounds*countries.length*amountPerCountry;
		Rate rate = RestClient.geRates(currencyCode.getCurrency().getCurrencyCode());

		
		// construct result
		Budget budget = new Budget(country, rounds, leftover);
		// calculate in country currency
		for(int i =0;i<countries.length;i++) {
			String neighbourCurrencyCode = CountryCode.getByCode(countries[i].getCountry_code()).getCurrency().getCurrencyCode();
			Double d = rate.getRates().get(neighbourCurrencyCode);
			if(d == null) {
				d = 1d;
			}
			budget.getCountryBudget().put(countries[i].getCountry_code(), amountPerCountry*d+ " "+neighbourCurrencyCode);
		}
		return budget;
	}

	@Override
	public boolean saveBudget(Budget usage) {
		logger.debug("Save calculated budget to database");
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isValidInput(String str) {
		return (str != null && str.trim().length() > 0 && str.length()<4);
	}
}
