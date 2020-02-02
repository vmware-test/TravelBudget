package org.demo.traveller.service.product;

import org.demo.traveller.model.Budget;


public interface IBudgetService  {	

	Budget calculateBudget(String country, String currency, int totalAmount, int amountPerCountry) throws Exception;
	
	boolean saveBudget(Budget usage);
}
