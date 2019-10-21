package com.surveyshrike.api.services;

import java.util.List;
import java.util.Optional;

import com.surveyshrike.api.exceptions.SurveyServiceException;
import com.surveyshrike.api.models.Survey;

public interface SurveyService {

	Survey createSurvey(Survey survey) throws SurveyServiceException;

	Optional<Survey> findSurvey(Long surveyId) throws SurveyServiceException;

	List<Survey> findAllSurveys() throws SurveyServiceException;
	
	List<Survey> findAllSurveysByCreatorId(String creatorId) throws SurveyServiceException;
}
