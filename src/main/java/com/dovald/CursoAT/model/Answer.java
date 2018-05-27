package com.dovald.CursoAT.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Answer {
	
	public static final String FIELD_QUESTION = "question";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String text;
	
	@JoinColumn(name = FIELD_QUESTION)
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;

}
