package com.surveyshrike.api.exceptions;

public class SurveyDAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public SurveyDAOException() {
		super();
	}

	public SurveyDAOException(String message) {
		super(message);
	}

	public SurveyDAOException(Exception exception) {
		super(exception);
	}

}
