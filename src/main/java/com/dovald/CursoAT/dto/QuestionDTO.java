package com.dovald.CursoAT.dto;

import java.util.List;

import com.dovald.CursoAT.model.Answer;

import lombok.Data;

@Data
public class QuestionDTO {
	
	private Integer id;	
	private String text;
	private Integer tag;
	private Integer difficulty;	
	private List<Answer> answer;

}
