package com.surveyshrike.api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("user_id")
	@Column(name = "userId")
	private Long userId;

	@Size(max = 50)
	@Column(name = "username")
	@JsonProperty("userName")
	private String userName;

	@Size(max = 100)
	@Column(name = "password")
	@JsonProperty("password")
	private String password;

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

	public User(String userName, String firstName, String lastName) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
//		try {
//			if (null != creationTime) {
//				String formattedDate = new SimpleDateFormat(QueryConstants.DATE_TIME_FORMAT).format(creationTime);
//				this.creationTime = formattedDate;
//			}
//		} catch (Exception exception) {
//			this.creationTime = creationTime.toString();
//		}
	}

}
