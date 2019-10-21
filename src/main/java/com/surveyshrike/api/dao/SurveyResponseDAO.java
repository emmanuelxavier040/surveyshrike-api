package com.surveyshrike.api.dao;

import java.util.List;
import java.util.Optional;

import com.surveyshrike.api.exceptions.SurveyResponseDAOException;
import com.surveyshrike.api.models.SurveyResponse;

public interface SurveyResponseDAO {

	List<SurveyResponse> findAllBySurveyId(Long surveyId) throws SurveyResponseDAOException;
	
	Optional<SurveyResponse> findByResponseId(Long responseId) throws SurveyResponseDAOException;
	
	SurveyResponse createSurveyResponse(SurveyResponse surveyResponse) throws SurveyResponseDAOException;
	
}
