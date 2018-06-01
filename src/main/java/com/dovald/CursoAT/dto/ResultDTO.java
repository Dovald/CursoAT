package com.dovald.CursoAT.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ResultDTO {
	
	private Integer id;
	private Integer score;
	private Date date;
	private Integer user;
	private Integer test;

}
