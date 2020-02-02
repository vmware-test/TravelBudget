package org.demo.traveller.controller;

import org.demo.traveller.model.User;
import org.demo.traveller.service.authentication.IAuthenticationService;
import org.demo.traveller.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private IUserService userService;
	@Autowired
	private IAuthenticationService authService;
	
	
	@RequestMapping(value = "/getById")
	public ResponseEntity<User> getUserById(@RequestBody Long userId) {
		User user = null;
		try {
			if (authService.isAuthenticate("", "")) {
//				user = userService.getUser(userId);		
//				if (null != user) {
					return new ResponseEntity<User>(user, HttpStatus.OK);
//				}
			}
		} catch(Exception e) {
			logger.error("ERROR! get user by id " , e);
		}

		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
}
