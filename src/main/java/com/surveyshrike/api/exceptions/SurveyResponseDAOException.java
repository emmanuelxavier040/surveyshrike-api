package com.surveyshrike.api.exceptions;

public class SurveyResponseDAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public SurveyResponseDAOException() {
		super();
	}

	public SurveyResponseDAOException(String message) {
		super(message);
	}

	public SurveyResponseDAOException(Exception exception) {
		super(exception);
	}

}
