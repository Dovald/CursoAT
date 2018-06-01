package com.dovald.CursoAT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dovald.CursoAT.component.mapper.answers_by_user.Answers_by_UserMapper;
import com.dovald.CursoAT.service.Answers_by_UserService;

@RestController
@RequestMapping(value = "/answers_by_user")
public class Answers_by_UserController {
	
	@Autowired
	Answers_by_UserService answers_by_userService;
	
	@Autowired
	Answers_by_UserMapper answers_by_userMapper;

}
