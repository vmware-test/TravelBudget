package org.demo.traveller.dao.budget;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.demo.traveller.model.Budget;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class BudgetMapper implements RowMapper<Budget> {

	@Override
	public Budget mapRow(ResultSet rs, int arg1) throws SQLException {
		Budget budget = new Budget();
		budget.setId(rs.getLong("id"));
		// TODO map all budget fields
		return budget;
	}

}
