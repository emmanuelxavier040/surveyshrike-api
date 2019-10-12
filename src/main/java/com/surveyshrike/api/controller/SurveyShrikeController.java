package com.surveyshrike.api.controller;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveyshrike.api.models.Choice;
import com.surveyshrike.api.models.Survey;
import com.surveyshrike.api.services.SurveyService;

@RestController
@RequestMapping("/api/v1")
public class SurveyShrikeController {

	@Autowired
	SurveyService surveyService;

	@PostMapping(path = "/create-survey", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Survey createSurvey(@RequestBody Survey survey) {
		System.out.println(survey.getCreatorName());
		return surveyService.createSurvey(survey);

	}

	@GetMapping(path = "/surveys", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Survey> getAllSurveys() {
		return surveyService.findAllSurveys();

	}
	
	@GetMapping("/survey/{id}")
	public Optional<Survey> getSurvey(@PathVariable(name = "id") Long surveyId) {
		return surveyService.findSurvey(surveyId);

	}
	
	@PostMapping(path = "/create-choice", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Survey createChoice(@RequestBody Choice choice) {
//		return surveyService.createSurvey(survey);
		return null;

	}
}
