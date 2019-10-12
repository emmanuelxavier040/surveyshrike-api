package com.surveyshrike.api.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveyshrike.api.exceptions.UserServiceException;
import com.surveyshrike.api.models.User;
import com.surveyshrike.api.services.UserService;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@CrossOrigin
@EnableSwagger2
@RequestMapping("/api/v1")
@Api(value = "SurveyShrike")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Controller method to get all users
	 * 
	 * @return List<User>
	 * @throws UserServiceException
	 */
	@GetMapping("/users")
	public List<User> getUsers() throws UserServiceException {
		return userService.findAll();

	}
}
