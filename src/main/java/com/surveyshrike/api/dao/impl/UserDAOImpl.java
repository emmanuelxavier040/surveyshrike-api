package com.surveyshrike.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.surveyshrike.api.dao.UserDAO;
import com.surveyshrike.api.exceptions.UserDAOException;
import com.surveyshrike.api.models.User;
import com.surveyshrike.api.repository.UserRepository;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() throws UserDAOException {
		List<User> users = null;
		try {
			users = (List<User>) userRepository.findAll();
		} catch (Exception exception) {
			throw new UserDAOException(exception);
		}
		return users;
	}

	@Override
	public User login(User user) throws UserDAOException {
		User userLoggedIn = null;
		try {			
			if(!userRepository.existsById(user.getEmail())) {
				userLoggedIn = (User) userRepository.save(user);
			}
			userLoggedIn = user;
		} catch (Exception exception) {
			throw new UserDAOException(exception);
		}
		return userLoggedIn;
	}

}
