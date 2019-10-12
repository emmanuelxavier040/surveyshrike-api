package com.surveyshrike.api.services;

import java.util.List;

import com.surveyshrike.api.exceptions.UserServiceException;
import com.surveyshrike.api.models.User;

public interface UserService {

	User signUp(User user) throws UserServiceException;

	List<User> findAll() throws UserServiceException;
}
