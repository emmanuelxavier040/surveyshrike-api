package com.surveyshrike.api.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.surveyshrike.api.dao.impl.SurveyResponseDAOImpl;
import com.surveyshrike.api.exceptions.SurveyResponseDAOException;
import com.surveyshrike.api.models.SurveyResponse;

public class SurveyResponseDAOImplTest {

	@InjectMocks
	private SurveyResponseDAO surveyResponseDAO = new SurveyResponseDAOImpl();

	@Test
	public void testFindAllBySurveyIdThrowsSurveyResponseDAOExceptionWithRightMessagehenRepositoryFails() {
		Long dumySurveyId = new Long(1);
		try {
			surveyResponseDAO.findAllBySurveyId(dumySurveyId);
		} catch (Exception exception) {
			assertEquals(SurveyResponseDAOException.class, exception.getClass());
			assertEquals("Exception while retrieving survey responses by survey id", exception.getMessage());
		}
	}

	@Test
	public void testFindByResponseIdThrowsSurveyDAOExceptionWhenRepositoryFails() {
		Long dumyResponseId = new Long(1);
		try {
			surveyResponseDAO.findByResponseId(dumyResponseId);
		} catch (Exception exception) {
			assertEquals(SurveyResponseDAOException.class, exception.getClass());
			assertEquals("Exception while finding response by response id", exception.getMessage());
		}
	}

	@Test
	public void testCreateSurveyResponseThrowsSurveyDAOExceptionWhenRepositoryFails() {
		SurveyResponse dummyInputSurveyResponse = new SurveyResponse();
		try {
			surveyResponseDAO.createSurveyResponse(dummyInputSurveyResponse);
		} catch (Exception exception) {
			assertEquals(SurveyResponseDAOException.class, exception.getClass());
			assertEquals("Exception while saving new survey response", exception.getMessage());
		}
	}

}
