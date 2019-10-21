package com.surveyshrike.api.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import com.surveyshrike.api.dao.impl.SurveyDAOImpl;
import com.surveyshrike.api.exceptions.SurveyDAOException;
import com.surveyshrike.api.models.Survey;
import com.surveyshrike.api.repository.SurveyRepository;

public class SurveyDAOImplTest {

	@InjectMocks
	private SurveyDAO surveyDAO = new SurveyDAOImpl();

	@Test
	public void testFindAllThrowsSurveyDAOExceptionWithRightMessagehenRepositoryFails() {
		try {
			surveyDAO.findAll();			
		} catch (Exception exception) {
			assertEquals(SurveyDAOException.class, exception.getClass());
			assertEquals("Exception while finding all survyes", exception.getMessage());
		}
	}

	@Test
	public void testCreateSurveyThrowsSurveyDAOExceptionWhenRepositoryFails() {
		Survey dummtyInputSurvey = new Survey();
		try {
			surveyDAO.createSurvey(dummtyInputSurvey);
		} catch (Exception exception) {
			assertEquals(SurveyDAOException.class, exception.getClass());
			assertEquals("Exception while saving the survey", exception.getMessage());
		}
	}

	@Test
	public void testFindAllSurveysByCreatorIdThrowsSurveyDAOExceptionWhenRepositoryFails() {
		String dummyCreatorId = "dummyId";
		try {
			surveyDAO.findAllSurveysByCreatorId(dummyCreatorId);
		} catch (Exception exception) {
			assertEquals(SurveyDAOException.class, exception.getClass());
			assertEquals("Exception while finding all survyes by Creator Id", exception.getMessage());
		}
	}

}
