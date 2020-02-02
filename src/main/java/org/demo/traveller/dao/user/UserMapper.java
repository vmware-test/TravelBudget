package org.demo.traveller.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.demo.traveller.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
//		user.setFirstName(rs.getString("first_name"));
//		user.setLastName(rs.getString("last_name")); 
//		user.setAddress(rs.getString("address"));
//		user.setActive(rs.getBoolean("is_active"));
//		
		return user;
	}

}
