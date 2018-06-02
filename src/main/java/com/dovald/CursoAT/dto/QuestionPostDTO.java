package com.dovald.CursoAT.dto;

import lombok.Data;

@Data
public class QuestionPostDTO {
	
	private Integer id;	
	private String text;
	private TagDTO tag;
	private DifficultyDTO difficulty;

}
