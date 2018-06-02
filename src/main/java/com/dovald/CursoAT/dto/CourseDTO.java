package com.dovald.CursoAT.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CourseDTO {
	
	private Integer id;
	private String name;
	private Date start_date;
	private Date end_date;
	private List<UserDTO> user;

}
