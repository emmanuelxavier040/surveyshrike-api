package com.surveyshrike.api.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveyshrike.api.exceptions.SurveyResponseServiceException;
import com.surveyshrike.api.exceptions.SurveyServiceException;
import com.surveyshrike.api.exceptions.SurveyShrikeException;
import com.surveyshrike.api.models.Survey;
import com.surveyshrike.api.models.SurveyResponse;
import com.surveyshrike.api.models.User;
import com.surveyshrike.api.services.SurveyResponseService;
import com.surveyshrike.api.services.SurveyService;
import com.surveyshrike.api.services.impl.SurveyServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class SurveyController {

	private final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);

	@Autowired
	SurveyService surveyService;

	@Autowired
	SurveyResponseService surveyResponseService;

	/**
	 * Controller method to create a new survey
	 * 
	 * @param survey
	 * @return
	 * @throws SurveyShrikeException
	 */
	@ApiOperation(value = "Create Survey")
	@PostMapping(path = "/create-survey", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Survey createSurvey(@RequestBody Survey survey) throws SurveyShrikeException {
		LOGGER.info("createSruvey : begin");
		String creatorId = User.getCurrentUser().getEmail();
		String creatorName = User.getCurrentUser().getFirstName();
		survey.setCreatorName(creatorName);
		survey.setCreatorId(creatorId);
		Survey createdSurvey = null;
		try {
			createdSurvey = surveyService.createSurvey(survey);
		} catch (SurveyServiceException exception) {
			throw new SurveyShrikeException(exception);
		}
		LOGGER.info("createSruvey : begin");
		return createdSurvey;

	}

	/**
	 * Controller method to retrieve all surveys
	 * 
	 * @param session
	 * @return
	 * @throws SurveyShrikeException
	 */
	@ApiOperation(value = "Get All Surveys")
	@GetMapping(path = "/surveys")
	public List<Survey> getAllSurveys(HttpSession session) throws SurveyShrikeException {
		LOGGER.info("getAllSurveys : begin");
		List<Survey> surveys = null;
		try {
			surveys = surveyService.findAllSurveys();
		} catch (SurveyServiceException exception) {
			throw new SurveyShrikeException(exception);
		}
		LOGGER.info("getAllSurveys : begin");
		return surveys;

	}

	/**
	 * Controller method to retrieve a survey by survey id
	 * 
	 * @param surveyId
	 * @return
	 * @throws SurveyShrikeException
	 */
	@ApiOperation(value = "Get a Survey")
	@GetMapping("/survey/{id}")
	public Optional<Survey> getSurvey(@PathVariable(name = "id") Long surveyId) throws SurveyShrikeException {
		LOGGER.info("getSurvey : begin");
		Optional<Survey> survey = null;
		try {
			survey = surveyService.findSurvey(surveyId);
		} catch (SurveyServiceException exception) {
			throw new SurveyShrikeException(exception);
		}
		LOGGER.info("getSurvey : begin");
		return survey;

	}

	/**
	 * Controller method to retrieve all surveys of a user
	 * 
	 * @return
	 * @throws SurveyShrikeException
	 */
	@ApiOperation(value = "Get all Surveys of a User")
	@GetMapping(path = "/my-surveys")
	public List<Survey> getMySurveys() throws SurveyShrikeException {
		LOGGER.info("getMySurveys : begin");
		List<Survey> surveys = null;
		try {
			String creatorId = User.getCurrentUser().getEmail();
			surveys = surveyService.findAllSurveysByCreatorId(creatorId);
		} catch (SurveyServiceException exception) {
			throw new SurveyShrikeException(exception);
		}
		LOGGER.info("getMySurveys : begin");
		return surveys;
	}

	/**
	 * Controller method to save a survey response
	 * 
	 * @param surveyResponse
	 * @return
	 */
	@ApiOperation(value = "Save Survey response")
	@PostMapping(path = "/take-survey", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SurveyResponse takeSurvey(@RequestBody SurveyResponse surveyResponse) throws SurveyShrikeException{
		LOGGER.info("takeSurvey : begin");
		String userId = User.getCurrentUser().getEmail();
		String userFirstName = User.getCurrentUser().getFirstName();
		surveyResponse.setUserId(userId);
		surveyResponse.setUserFirstName(userFirstName);
		SurveyResponse newSurveyResponse = null;
		try {
			newSurveyResponse = surveyResponseService.createSurveyResponse(surveyResponse);
		} catch (SurveyResponseServiceException exception) {
			throw new SurveyShrikeException(exception);
		}
		LOGGER.info("takeSurvey : begin");
		return newSurveyResponse;
	}

	/**
	 * Controller method to retrieve survey responses by survey id
	 * 
	 * @param surveyId
	 * @return
	 */
	@ApiOperation(value = "Get all responses for a Survey")
	@GetMapping(path = "/survey-responses/{id}")
	public List<SurveyResponse> getAllResponsesForASurvey(@PathVariable(name = "id") Long surveyId) throws SurveyShrikeException{
		LOGGER.info("getAllResponsesForASurvey : begin");
		List<SurveyResponse> surveyResponses = null;
		try {
			surveyResponses = surveyResponseService.findAllSurveyResponsesBySurveyId(surveyId);
		} catch (SurveyResponseServiceException exception) {
			throw new SurveyShrikeException(exception);
		}
		LOGGER.info("getAllResponsesForASurvey : begin");
		return surveyResponses;
	}

	/**
	 * Controller method to retrieve survey response by response id
	 * 
	 * @param responseId
	 * @return
	 */
	@ApiOperation(value = "Get a Response for a Survey")
	@GetMapping(path = "/survey-response/{id}")
	public Optional<SurveyResponse> getSurveyResponse(@PathVariable(name = "id") Long responseId) throws SurveyShrikeException{
		LOGGER.info("getSurveyResponse : begin");
		Optional<SurveyResponse> surveyResponse = null;
		try {
			surveyResponse = surveyResponseService.findSurveyResponseByResponseId(responseId);
		} catch (SurveyResponseServiceException exception) {
			throw new SurveyShrikeException(exception);
		}
		LOGGER.info("getSurveyResponse : begin");
		return surveyResponse;
	}

}
