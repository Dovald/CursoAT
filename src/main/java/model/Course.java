package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	private Integer idUser;

	@Column(nullable = false)
	private String name;
	
	@JoinColumn(name = FIELD_USER)
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = User.FIELD_COURSE)
	private List<User> user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Test.FIELD_COURSE)
	private List<Test> test;

}
