package com.surveyshrike.api.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.surveyshrike.api.dao.SurveyDAO;
import com.surveyshrike.api.models.Survey;
import com.surveyshrike.api.repository.SurveyRepository;

@Component
public class SurveyDAOImpl implements SurveyDAO {

	@Autowired
	private SurveyRepository surveyRepository;

	@Override
	public List<Survey> findAll() {
		List<Survey> users = null;
		try {
			users = (List<Survey>) surveyRepository.findAll();
		} catch (Exception exception) {
//			throw new UserDAOException(exception);
			return null;
		}
		return users;
	}

	@Override
	public Survey createSurvey(Survey survey) {
		return surveyRepository.save(survey);
	}

	@Override
	public Optional<Survey> findSurveyById(Long surveyId) {
		return surveyRepository.findById(surveyId);
	}

}
