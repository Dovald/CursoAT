package com.dovald.CursoAT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dovald.CursoAT.service.ResultService;

@Controller
public class ResultController {
	
	@Autowired
	ResultService resultService;

}
