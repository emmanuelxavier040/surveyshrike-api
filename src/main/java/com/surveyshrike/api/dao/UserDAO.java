package com.surveyshrike.api.dao;

import java.util.List;

import com.surveyshrike.api.exceptions.UserDAOException;
import com.surveyshrike.api.models.User;

public interface UserDAO {

	List<User> findAll() throws UserDAOException;
}
