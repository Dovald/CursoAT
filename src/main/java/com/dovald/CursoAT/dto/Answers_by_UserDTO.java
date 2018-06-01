package com.dovald.CursoAT.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Answers_by_UserDTO {
	
	private Integer id;
	private Integer question;
	private Integer answer;
	private Date date;
	private Integer idUser;
	private Integer idTest;

}
