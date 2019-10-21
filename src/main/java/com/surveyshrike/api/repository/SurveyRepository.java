package com.surveyshrike.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.surveyshrike.api.models.Survey;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

	@Query("SELECT sr FROM Survey sr WHERE sr.creatorId = ?1")
	List<Survey> findAllByCreatorId(String creatorId);
}
