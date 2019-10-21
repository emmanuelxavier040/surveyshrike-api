package com.surveyshrike.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveyshrike.api.dao.SurveyDAO;
import com.surveyshrike.api.exceptions.SurveyDAOException;
import com.surveyshrike.api.exceptions.SurveyServiceException;
import com.surveyshrike.api.models.Survey;
import com.surveyshrike.api.services.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService {

	private final Logger LOGGER = LoggerFactory.getLogger(SurveyServiceImpl.class);

	@Autowired
	SurveyDAO surveyDao;

	@Override
	public Survey createSurvey(Survey survey) throws SurveyServiceException {
		LOGGER.info("createSruvey : begin");
		Survey createdSurvey = null;
		try {
			createdSurvey = surveyDao.createSurvey(survey);
		} catch (SurveyDAOException exception) {
			throw new SurveyServiceException(exception);
		}
		LOGGER.info("createSruvey : end");
		return createdSurvey;
	}

	@Override
	public Optional<Survey> findSurvey(Long surveyId) throws SurveyServiceException {
		LOGGER.info("findSurvey : begin");
		Optional<Survey> survey = null;
		try {
			survey = surveyDao.findSurveyById(surveyId);
		} catch (SurveyDAOException exception) {
			throw new SurveyServiceException(exception);
		}
		LOGGER.info("findSurvey : end");
		return survey;
	}

	@Override
	public List<Survey> findAllSurveys() throws SurveyServiceException {
		LOGGER.info("findAllSurveys : begin");
		List<Survey> surveys = null;
		try {
			surveys = surveyDao.findAll();
		} catch (SurveyDAOException exception) {
			throw new SurveyServiceException(exception);
		}
		LOGGER.info("findAllSurveys : end");
		return surveys;
	}

	@Override
	public List<Survey> findAllSurveysByCreatorId(String creatorId) throws SurveyServiceException {
		LOGGER.info("findAllSurveysByCreatorId : begin");
		List<Survey> surveys = null;
		try {
			surveys = surveyDao.findAllSurveysByCreatorId(creatorId);
		} catch (SurveyDAOException exception) {
			throw new SurveyServiceException(exception);
		}
		LOGGER.info("findAllSurveysByCreatorId : end");
		return surveys;
	}

}
