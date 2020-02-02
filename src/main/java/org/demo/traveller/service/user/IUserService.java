package org.demo.traveller.service.user;


import org.demo.traveller.model.User;


public interface IUserService {	
		
	public User	getUser(long userId);
	public User	getUser(String address);
	public boolean insertUser(User user) throws Exception;
	
}
