package com.surveyshrike.api.dao;

import java.util.List;

import com.surveyshrike.api.models.Choice;

public interface ChoiceDAO {

	List<Choice> findAllByQuestionId(Long questionId);
}
