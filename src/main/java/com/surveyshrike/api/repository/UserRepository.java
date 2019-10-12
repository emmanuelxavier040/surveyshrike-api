package com.surveyshrike.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.surveyshrike.api.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
