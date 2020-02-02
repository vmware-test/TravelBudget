package org.demo.traveller;

import org.demo.traveller.model.Budget;
import org.demo.traveller.service.product.IBudgetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;


@RunWith(SpringJUnit4ClassRunner.class)  
@SpringApplicationConfiguration(classes = Application.class)
public class BudgetServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(BudgetServiceTest.class);
	@Autowired
	private IBudgetService budgetService;
	
	@Test
    public void testCalculateBuget() throws Exception {
		try {
			Budget budget = budgetService.calculateBudget("BG", "EUR", 1200, 100);
			Assert.assertEquals(budget.getRoundTrips().intValue(), 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}		
	}
	

}
