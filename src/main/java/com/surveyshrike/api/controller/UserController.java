package com.surveyshrike.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.surveyshrike.api.exceptions.SurveyShrikeException;
import com.surveyshrike.api.exceptions.UserServiceException;
import com.surveyshrike.api.models.JwtResponse;
import com.surveyshrike.api.models.User;
import com.surveyshrike.api.security.GoogleTokenService;
import com.surveyshrike.api.security.JwtTokenProvider;
import com.surveyshrike.api.services.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserController {

	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private GoogleTokenService googleTokenService;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	/**
	 * Controller method to get all users
	 * 
	 * @return List<User>
	 * @throws SurveyShrikeException
	 */
	@ApiOperation(value = "Get all users")
	@GetMapping("/users")
	public List<User> getUsers() throws SurveyShrikeException {
		LOGGER.info("getUsers : begin");
		List<User> users = null;
		try {
			users = userService.findAll();
		} catch (UserServiceException exception) {
			throw new SurveyShrikeException(exception);
		}
		LOGGER.info("getUsers : begin");
		return users;
	}

	/**
	 * Controller method for the user to login and create new JWT token after
	 * validating the google token received
	 * 
	 * @return User
	 * @throws SurveyShrikeException
	 */
	@ApiOperation(value = "User Login")
	@GetMapping("/login")
	public JwtResponse loginUser(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws SurveyShrikeException {
		LOGGER.info("loginUser : Begin ");
		String googleToken = request.getHeader("Google-Token");
		String JWT = "";
		if (googleToken != null && StringUtils.hasText(googleToken)) {
			try {
				Payload payload = googleTokenService.verifyGoogleToken(googleToken);
				String userId = payload.getSubject();
				String email = payload.getEmail();
				String lastName = (String) payload.get("family_name");
				String firstName = (String) payload.get("given_name");
				User user = new User(email, userId, firstName, lastName);
				user = userService.loginUser(user);
				JWT = jwtTokenProvider.generateJwtToken(response, user);
			} catch (Exception ex) {
				LOGGER.error("loginUser : Exception " + ex.getMessage());
				throw new SurveyShrikeException(ex);
			}
		}
		LOGGER.info("loginUser : End ");
		return new JwtResponse(JWT);

	}

	/**
	 * Controller method to verify authorization
	 * 
	 * @return true
	 */
	@ApiOperation(value = "Authorization Check")
	@GetMapping("/authorize")
	public boolean authorizeEndPoint() {
		LOGGER.info("authorizeEndPoint : success");
		return true;
	}
}
