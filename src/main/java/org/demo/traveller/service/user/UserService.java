package org.demo.traveller.service.user;

import org.demo.traveller.dao.user.IUsersDao;
import org.demo.traveller.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	protected IUsersDao usersDao;

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


}
