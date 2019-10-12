package com.surveyshrike.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.surveyshrike.api.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

}
