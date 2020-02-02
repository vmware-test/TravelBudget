package org.demo.traveller.dao.user;

import org.demo.traveller.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository("UsersDao")
public class UsersDao implements IUsersDao {

	private static final Logger logger = LoggerFactory.getLogger(UsersDao.class);
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	protected UserMapper userMapper;
	
	
	public void insertUser(User user) {
		// TODO
	}
	
	public User getUser(long userId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource()
		.addValue("USER_ID", userId);
				
		try {
			return jdbcTemplate.queryForObject(GET_USER_BY_ID, namedParameters, userMapper);
		} catch (DataAccessException e) {
			logger.error("can't find user :", e);
		}
		return null;
	}
	
	public User getUser(String address) {
		SqlParameterSource namedParameters = new MapSqlParameterSource()
		.addValue("ADDRESS", address);
				
		try {
			return jdbcTemplate.queryForObject(GET_USER_BY_ADDRESS, namedParameters, userMapper);
		} catch (DataAccessException e) {
			logger.error("can't find user :", e);
		}
		return null;
	}
	
	
}
