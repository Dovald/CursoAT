package com.dovald.CursoAT.dto;

import java.util.List;

import lombok.Data;

@Data
public class TestDTO {
	
	private Integer id;
	private String name;
	private List<String> tag;
	private String course;

}
