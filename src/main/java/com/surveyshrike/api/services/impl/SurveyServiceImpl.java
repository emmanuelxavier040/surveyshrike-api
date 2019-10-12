package com.surveyshrike.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveyshrike.api.dao.SurveyDAO;
import com.surveyshrike.api.models.Survey;
import com.surveyshrike.api.services.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	SurveyDAO surveyDao;

	@Override
	public Survey createSurvey(Survey survey) {
		return surveyDao.createSurvey(survey);
	}

	@Override
	public Optional<Survey> findSurvey(Long surveyId) {
		return surveyDao.findSurveyById(surveyId);
	}

	@Override
	public List<Survey> findAllSurveys() {
		return surveyDao.findAll();
	}

}
