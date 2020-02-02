package org.demo.traveller.dao.budget;

import java.util.List;

import org.demo.traveller.model.Budget;

public interface IBudgetDao {

	
	static final String GET_USAGE =	"SELECT * FROM USAGE WHERE USER_ID = :USER_ID AND MONITORING_TYPE_ID = :MONITORING_TYPE_ID AND DATE_TAKEN - now() < :PERIOD";
	static final String PUT_USAGE = "INSERT INTO USAGE (MONITORING_TYPE_ID, USER_ID, EMPLOYEE_ID, MEASUREMENT, DATE_TAKEN) "
											+ "VALUES	(:MONITORING_TYPE_ID, :USER_ID, :EMPLOYEE_ID, :MEASUREMENT, now())";

	List<Budget> getUsage(long user_id, int type, int periodDays);
	boolean putUsage(Budget usage);
}
