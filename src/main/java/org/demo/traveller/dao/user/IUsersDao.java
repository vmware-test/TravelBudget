package org.demo.traveller.dao.user;

import org.demo.traveller.model.User;

public interface IUsersDao {
	
	static final String GET_USER_BY_ID		=	"SELECT * FROM USERS WHERE ID = :USER_ID";
	static final String GET_USER_BY_ADDRESS	=	"SELECT * FROM USERS WHERE ADDRESS = :ADDRESS";
	
	public void insertUser(User user) ;
	public User getUser(long userId); 
	public User getUser(String address); 
}
