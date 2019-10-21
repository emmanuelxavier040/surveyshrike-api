package com.surveyshrike.api.exceptions;

public class SurveyShrikeException extends Exception {

	private static final long serialVersionUID = 1L;

	public SurveyShrikeException() {
		super();
	}

	public SurveyShrikeException(String message) {
		super(message);
	}

	public SurveyShrikeException(Exception exception) {
		super(exception);
	}

}
