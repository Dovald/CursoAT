package com.dovald.CursoAT.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answers_by_User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String question;
	
	@Column(nullable = false)
	private String answer;
	
	@Column(nullable = false)
	private boolean isCorrect;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(nullable = false)
	private Integer idUser;
	
	@Column(nullable = false)
	private Integer idTest;
	
	@Column(nullable = false)
	private Integer idAnswer;
	
	@Column(nullable = false)
	private Integer idQuestion;

}
