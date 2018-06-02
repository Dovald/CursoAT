package com.dovald.CursoAT.dto;

import java.util.List;

import lombok.Data;

@Data
public class TestGetDTO {
	
	private Integer id;
	private List<QuestionDTO> question;

}
