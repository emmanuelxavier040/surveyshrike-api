package com.surveyshrike.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.surveyshrike.api.constants.AnswerType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Long questionId;

	@JsonProperty(value = "orderNumber")
	@Column(name = "order_number")
	private Long orderNumber;

	@JsonProperty(value = "questionText")
	@Column(name = "question_text")
	private String questionText;

	@JsonProperty(value = "answerType")
	@Enumerated(EnumType.STRING)
	@Column(name = "answer_type")
	private AnswerType answerType;

	@JsonProperty(value = "placeholder")
	@Column(name = "placeholder")
	private String placeholder;

	@JsonProperty(value = "choices")
	@Column(name = "choices")
	private String choices;

}
