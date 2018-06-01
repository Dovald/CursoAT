package com.dovald.CursoAT.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerPostDTO extends AnswerDTO {
	
	public boolean isCorrect;
	public Integer idQuestion;

}
