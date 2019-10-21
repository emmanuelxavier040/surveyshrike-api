package com.surveyshrike.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.surveyshrike.api.security.AuthenticatedUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable{

	@Id
	@Size(max = 50)
	@Column(name = "email")
	@JsonProperty("email")
	private String email;
	
	@Size(max = 50)
	@Column(name = "username")
	@JsonProperty("userName")
	private String userName;
	
	@Size(max = 50)
	@Column(name = "first_name")
	@JsonProperty("firstName")
	private String firstName;

	@Size(max = 50)
	@Column(name = "last_name")
	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("creation_time")
	@Column(name = "creationTime")	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;

	public User() {
	}

	public User(String email, String userName, String firstName, String lastName) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static User getCurrentUser() {
		User currentUser = ((AuthenticatedUser)(SecurityContextHolder.getContext().getAuthentication())).getAuthenticatedUser();
		return currentUser;
	}
}
