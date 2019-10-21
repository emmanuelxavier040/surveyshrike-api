package com.surveyshrike.api.exceptions;

public class SurveyServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public SurveyServiceException() {
		super();
	}

	public SurveyServiceException(String message) {
		super(message);
	}

	public SurveyServiceException(Exception exception) {
		super(exception);
	}

}
