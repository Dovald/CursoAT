package com.dovald.CursoAT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dovald.CursoAT.service.AnswerService;

@Controller
public class AnswerController {
	
	@Autowired
	AnswerService answerService;

}
