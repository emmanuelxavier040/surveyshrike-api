package com.surveyshrike.api.services;

import java.util.List;
import java.util.Optional;

import com.surveyshrike.api.exceptions.SurveyResponseServiceException;
import com.surveyshrike.api.models.SurveyResponse;

public interface SurveyResponseService {

	SurveyResponse createSurveyResponse(SurveyResponse surveyResponse) throws SurveyResponseServiceException;

	Optional<SurveyResponse> findSurveyResponseByResponseId(Long responseId) throws SurveyResponseServiceException;
	
	List<SurveyResponse> findAllSurveyResponsesBySurveyId(Long surveyId) throws SurveyResponseServiceException;
}
