package com.dovald.CursoAT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dovald.CursoAT.service.DifficultyService;

@Controller
public class DifficultyController {
	
	@Autowired
	DifficultyService difficultyService;

}
