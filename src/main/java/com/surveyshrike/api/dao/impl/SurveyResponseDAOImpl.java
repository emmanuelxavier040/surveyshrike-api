package com.surveyshrike.api.dao.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.surveyshrike.api.dao.SurveyResponseDAO;
import com.surveyshrike.api.exceptions.SurveyResponseDAOException;
import com.surveyshrike.api.models.SurveyResponse;
import com.surveyshrike.api.repository.SurveyResponseRepository;

@Component
public class SurveyResponseDAOImpl implements SurveyResponseDAO {

	private final Logger LOGGER = LoggerFactory.getLogger(SurveyResponseDAOImpl.class);

	@Autowired
	private SurveyResponseRepository surveyResponseRepository;

	/**
	 * DAO method to find all survey responses of a survey
	 */
	@Override
	public List<SurveyResponse> findAllBySurveyId(Long surveyId) throws SurveyResponseDAOException{
		LOGGER.info("findAllBySurveyId : begin");
		List<SurveyResponse> surveyResponses = null;
		try {
			surveyResponses = (List<SurveyResponse>) surveyResponseRepository.findAllBySurveyId(surveyId);
		} catch (Exception exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyResponseDAOException("Exception while retrieving survey responses by survey id");			
		}
		LOGGER.info("findAllBySurveyId : end");
		return surveyResponses;
	}

	/**
	 * DAO method to find a response of survey with response id
	 */
	@Override
	public Optional<SurveyResponse> findByResponseId(Long responseId) throws SurveyResponseDAOException{
		LOGGER.info("findByResponseId : begin");
		Optional<SurveyResponse> surveyResponses = null;
		try {
			surveyResponses = (Optional<SurveyResponse>) surveyResponseRepository.findById(responseId);
		} catch (Exception exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyResponseDAOException("Exception while finding response by response id");			
		}
		LOGGER.info("findByResponseId : end");
		return surveyResponses;
	}

	/**
	 * DAO method to create a response to the survey
	 */
	@Override
	public SurveyResponse createSurveyResponse(SurveyResponse surveyResponse) throws SurveyResponseDAOException{	
		LOGGER.info("createSurveyResponse : begin");
		SurveyResponse newSurveyResponses = null;
		try {
			newSurveyResponses = (SurveyResponse) surveyResponseRepository.save(surveyResponse);
		} catch (Exception exception) {
			LOGGER.error("Exception : " + exception.getMessage());
			throw new SurveyResponseDAOException("Exception while saving new survey response");			
		}
		LOGGER.info("createSurveyResponse : end");
		return newSurveyResponses;
	}


}
