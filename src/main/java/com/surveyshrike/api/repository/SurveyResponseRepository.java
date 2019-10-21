package com.surveyshrike.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.surveyshrike.api.models.SurveyResponse;

@Repository
public interface SurveyResponseRepository extends CrudRepository<SurveyResponse, Long> {

	@Query("SELECT sr FROM SurveyResponse sr WHERE sr.surveyId = ?1")
	List<SurveyResponse> findAllBySurveyId(Long surveyId);

}
