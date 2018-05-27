package com.dovald.CursoAT.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Question {
	
	public static final String FIELD_TEST = "test";
	public static final String FIELD_TAG = "tag";
	public static final String FIELD_DIFFICULTY = "difficulty";
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String text;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Test> test;
	
	@JoinColumn(name = FIELD_TAG)
	@ManyToOne(fetch = FetchType.LAZY)
	private Tag tag;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Answer.FIELD_QUESTION)
	@Size(min=0,max=4)
	private List<Answer> answer;
	
	@JoinColumn(name = FIELD_DIFFICULTY)
	@ManyToOne(fetch = FetchType.LAZY)
	private Difficulty difficulty;

}
