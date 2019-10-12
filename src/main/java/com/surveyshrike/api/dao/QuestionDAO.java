package com.surveyshrike.api.dao;

import java.util.List;

import com.surveyshrike.api.models.Question;

public interface QuestionDAO {

	List<Question> findAllBySurveyId(Long surveyId);
}
