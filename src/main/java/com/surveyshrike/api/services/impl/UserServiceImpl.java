package com.surveyshrike.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveyshrike.api.dao.UserDAO;
import com.surveyshrike.api.exceptions.UserServiceException;
import com.surveyshrike.api.models.User;
import com.surveyshrike.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public User signUp(User user) throws UserServiceException {
		return null;
	}

	@Override
	public List<User> findAll() throws UserServiceException {
		List<User> users = null;
		try {
			users = userDAO.findAll();
		} catch (Exception exception) {
			throw new UserServiceException(exception);
		}
		return users;
	}

	@Override
	public User loginUser(User user) throws UserServiceException {
		User userloggedIn = null;
		try {
			userloggedIn = userDAO.login(user);
		} catch (Exception exception) {
			throw new UserServiceException(exception);
		}
		return userloggedIn;
	}

}
