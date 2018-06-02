package com.dovald.CursoAT.dto;

import java.util.List;

import lombok.Data;

@Data
public class QuestionDTO {
	
	private Integer id;
	private String text;
	private TagDTO tag;
	private DifficultyDTO difficulty;	
	private List<AnswerDTO> answer;

}
