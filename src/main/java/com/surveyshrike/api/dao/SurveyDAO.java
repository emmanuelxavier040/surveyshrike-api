package com.surveyshrike.api.dao;

import java.util.List;
import java.util.Optional;

import com.surveyshrike.api.models.Survey;

public interface SurveyDAO {

	List<Survey> findAll();
	
	Survey createSurvey(Survey survey);
	
	Optional<Survey> findSurveyById(Long surveyId);
}
