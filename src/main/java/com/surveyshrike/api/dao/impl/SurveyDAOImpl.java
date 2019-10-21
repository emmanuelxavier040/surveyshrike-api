package com.surveyshrike.api.dao.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.surveyshrike.api.dao.SurveyDAO;
import com.surveyshrike.api.exceptions.SurveyDAOException;
import com.surveyshrike.api.models.Survey;
import com.surveyshrike.api.repository.SurveyRepository;

@Component
public class SurveyDAOImpl implements SurveyDAO {

	private final Logger LOGGER = LoggerFactory.getLogger(SurveyDAOImpl.class);

	@Autowired
	private SurveyRepository surveyRepository;

	/**
	 * DAO method to retrieve all surveys
	 */
	@Override
	public List<Survey> findAll() throws SurveyDAOException {
		LOGGER.info("findAll : begin");
		List<Survey> surveys = null;
		try {
			surveys = (List<Survey>) surveyRepository.findAll();
		} catch (Exception exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyDAOException("Exception while finding all survyes");
		}
		LOGGER.info("findAll : begin");
		return surveys;
	}

	/**
	 * DAO method to create a new survey
	 */
	@Override
	public Survey createSurvey(Survey survey) throws SurveyDAOException {
		LOGGER.info("createSurvey : begin");
		Survey surveySaved = null;
		try {
			surveySaved = (Survey) surveyRepository.save(survey);
		} catch (Exception exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyDAOException("Exception while saving the survey");
		}
		LOGGER.info("createSurvey : begin");
		return surveySaved;
	}

	/**
	 * DAO method to find a survey with survey Id
	 */
	@Override
	public Optional<Survey> findSurveyById(Long surveyId) throws SurveyDAOException {
		LOGGER.info("findSurveyById : begin");
		Optional<Survey> survey = null;
		try {
			survey = (Optional<Survey>) surveyRepository.findById(surveyId);
		} catch (Exception exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyDAOException("Exception while finding the survey by Survey Id");
		}
		LOGGER.info("findSurveyById : begin");
		return survey;
	}

	/**
	 * DAO method to find all surveys of a creator with creator id
	 */
	@Override
	public List<Survey> findAllSurveysByCreatorId(String creatorId) throws SurveyDAOException {
		LOGGER.info("findAllSurveysByCreatorId : begin");
		List<Survey> surveys = null;
		try {
			surveys = (List<Survey>) surveyRepository.findAllByCreatorId(creatorId);
		} catch (Exception exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyDAOException("Exception while finding all survyes by Creator Id");
		}
		LOGGER.info("findAllSurveysByCreatorId : begin");
		return surveys;
	}

}
