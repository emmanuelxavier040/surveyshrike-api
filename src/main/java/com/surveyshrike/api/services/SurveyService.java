package com.surveyshrike.api.services;

import java.util.List;
import java.util.Optional;

import com.surveyshrike.api.models.Survey;

public interface SurveyService {

	Survey createSurvey(Survey survey);

	Optional<Survey> findSurvey(Long surveyId);

	List<Survey> findAllSurveys();
}
