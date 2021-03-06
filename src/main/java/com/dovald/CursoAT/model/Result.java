package com.dovald.CursoAT.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Result {

	public static final String FIELD_USER = "user";
	public static final String FIELD_TEST = "test";

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private Integer score;

	@Temporal(TemporalType.DATE)
	private Date date;

	@JoinColumn(name = FIELD_USER)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@JoinColumn(name = FIELD_TEST)
	@ManyToOne(fetch = FetchType.LAZY)
	private Test test;
}
