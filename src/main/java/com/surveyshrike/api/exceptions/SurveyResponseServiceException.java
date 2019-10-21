package com.surveyshrike.api.exceptions;

public class SurveyResponseServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public SurveyResponseServiceException() {
		super();
	}

	public SurveyResponseServiceException(String message) {
		super(message);
	}

	public SurveyResponseServiceException(Exception exception) {
		super(exception);
	}

}
