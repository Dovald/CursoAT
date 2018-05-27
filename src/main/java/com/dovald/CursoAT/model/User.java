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
public class User {
	
	public static final String FIELD_COURSE = "course";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_USER)
	private List<Result> result;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Course.FIELD_USER)
	private List<Course> course;
	
	public String toString() {
		return this.getName()+","+this.getEmail();
	}

}
