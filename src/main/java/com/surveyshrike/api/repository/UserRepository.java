package com.surveyshrike.api.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.surveyshrike.api.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
