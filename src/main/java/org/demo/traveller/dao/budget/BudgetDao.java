package org.demo.traveller.dao.budget;

import java.util.List;

import org.demo.traveller.model.Budget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


@Primary
@Repository("BudgetDao")
public class BudgetDao implements IBudgetDao {
	private static final Logger logger = LoggerFactory.getLogger(BudgetDao.class);
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	protected BudgetMapper usageMapper;

	

	@Override
	public List<Budget> getUsage(long userId, int type, int periodDays) {
		SqlParameterSource namedParameters = new MapSqlParameterSource()
		.addValue("USER_ID", userId)
		.addValue("MONITORING_TYPE_ID", type)
		.addValue("PERIOD", periodDays);
		
		
		try {
			return jdbcTemplate.query(GET_USAGE, namedParameters, usageMapper);
		} catch (DataAccessException e) {
			logger.error("can't find usage!", e);
		}
		return null;
	}


	@Override
	public boolean putUsage(Budget usage) {
		SqlParameterSource namedParameters = new MapSqlParameterSource()
		.addValue("USER_ID", usage.getUserId());
//		.addValue("MONITORING_TYPE_ID", usage.getMonitoringType())
//		.addValue("EMPLOYEE_ID", usage.getEmployeeId())
//		.addValue("MEASUREMENT", usage.getMeasurement());
		return (jdbcTemplate.update(PUT_USAGE, namedParameters) > 0);
	}
}
