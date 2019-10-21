package com.surveyshrike.api.dao;

import java.util.List;
import java.util.Optional;

import com.surveyshrike.api.exceptions.SurveyDAOException;
import com.surveyshrike.api.models.Survey;

public interface SurveyDAO {

	List<Survey> findAll() throws SurveyDAOException;
	
	Survey createSurvey(Survey survey) throws SurveyDAOException;
	
	Optional<Survey> findSurveyById(Long surveyId) throws SurveyDAOException;
	
	List<Survey> findAllSurveysByCreatorId(String creatorId) throws SurveyDAOException;
}
