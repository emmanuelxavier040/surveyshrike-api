package com.surveyshrike.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.surveyshrike.api.models.Choice;

@Repository
public interface ChoiceRepository extends CrudRepository<Choice, Long> {

}
