package com.surveyshrike.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveyshrike.api.dao.SurveyResponseDAO;
import com.surveyshrike.api.exceptions.SurveyResponseDAOException;
import com.surveyshrike.api.exceptions.SurveyResponseServiceException;
import com.surveyshrike.api.models.SurveyResponse;
import com.surveyshrike.api.services.SurveyResponseService;

@Service
public class SurveyResponseServiceImpl implements SurveyResponseService {

	private final Logger LOGGER = LoggerFactory.getLogger(SurveyResponseServiceImpl.class);

	@Autowired
	private SurveyResponseDAO surveyResponseDAO;

	@Override
	public SurveyResponse createSurveyResponse(SurveyResponse surveyResponse) throws SurveyResponseServiceException{
		LOGGER.info("createSurveyResponse : begin");
		SurveyResponse newsurveyResponse = null;
		try {
			newsurveyResponse = surveyResponseDAO.createSurveyResponse(surveyResponse);
		} catch (SurveyResponseDAOException exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyResponseServiceException(exception);			
		}
		LOGGER.info("createSurveyResponse : end");
		return newsurveyResponse;
	}

	@Override
	public Optional<SurveyResponse> findSurveyResponseByResponseId(Long responseId) throws SurveyResponseServiceException{
		LOGGER.info("findSurveyResponseByResponseId : begin");
		Optional<SurveyResponse> surveyResponse = null;
		try {
			surveyResponse = surveyResponseDAO.findByResponseId(responseId);
		} catch (SurveyResponseDAOException exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyResponseServiceException(exception);			
		}
		LOGGER.info("findSurveyResponseByResponseId : end");
		return surveyResponse;
	}

	@Override
	public List<SurveyResponse> findAllSurveyResponsesBySurveyId(Long surveyId) throws SurveyResponseServiceException{
		LOGGER.info("findAllSurveyResponsesBySurveyId : begin");
		List<SurveyResponse> surveyResponse = null;
		try {
			surveyResponse = surveyResponseDAO.findAllBySurveyId(surveyId);
		} catch (SurveyResponseDAOException exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyResponseServiceException(exception);			
		}
		LOGGER.info("findAllSurveyResponsesBySurveyId : end");
		return surveyResponse;
	}

}
