package org.demo.traveller.service.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

	@Override
	public boolean isAuthenticate(String userName, String password) {
		// TODO implement authentication
		logger.debug("Auth request for:" + userName);
		return true;
	}

	
}
