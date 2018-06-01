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

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Test {
	
	public static final String FIELD_COURSE = "course";
	
	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true,nullable = false)
	private String name;
	
	@JoinColumn(name = FIELD_COURSE)
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_TEST)
	private List<Result> result;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_TEST)
	private List<Question> question;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Tag.FIELD_TEST)
	private List<Tag> tag;

}
