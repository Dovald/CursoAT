package com.dovald.CursoAT.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Answers_by_UserDTO {
	
	private Integer id;
	private String question;
	private AnswerDTO answer;
	private Date date;
	private Integer idUser;
	private Integer idTest;
	private boolean isCorrect;

}
