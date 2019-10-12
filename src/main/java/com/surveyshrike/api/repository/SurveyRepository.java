package com.surveyshrike.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.surveyshrike.api.models.Survey;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

}
