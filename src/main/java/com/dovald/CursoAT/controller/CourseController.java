package com.dovald.CursoAT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dovald.CursoAT.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	CourseService courseService;

}
