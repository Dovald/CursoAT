package com.dovald.CursoAT.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Tag {
	
	public static final String FIELD_TEST = "test";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_TAG)
	private List<Question> question;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Test> test;

}
