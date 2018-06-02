package com.dovald.CursoAT.dto;

import java.util.List;

import lombok.Data;

@Data
public class TestPutDTO {
	
	private Integer id;
	private String name;
	private Integer idCourse;
	private List<QuestionDTO> question;

}
