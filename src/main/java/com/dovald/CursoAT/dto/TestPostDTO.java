package com.dovald.CursoAT.dto;

import java.util.List;

import lombok.Data;

@Data
public class TestPostDTO {
	
	private Integer id;
	private String name;
	private List<TagDTO> tag;
	private CourseDTO course;

}
