package com.dovald.CursoAT.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Course {
	
	public static final String FIELD_USER = "user";
	public static final String FIELD_TEST = "test";
	
	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date start_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date end_date;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Test.FIELD_COURSE)
	private List<Test> test;
}
