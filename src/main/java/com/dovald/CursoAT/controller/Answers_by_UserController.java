package com.dovald.CursoAT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dovald.CursoAT.component.mapper.answers_by_user.Answers_by_UserMapper;
import com.dovald.CursoAT.component.mapper.result.ResultMapper;
import com.dovald.CursoAT.dto.Answers_by_UserDTO;
import com.dovald.CursoAT.dto.ResultDTO;
import com.dovald.CursoAT.exception.BadAnswersException;
import com.dovald.CursoAT.exception.BadFieldsException;
import com.dovald.CursoAT.exception.EmptyFieldException;
import com.dovald.CursoAT.exception.NotEnoughFieldsException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.exception.TooManyFieldsException;
import com.dovald.CursoAT.service.Answers_by_UserService;

@RestController
@RequestMapping(value = "/answers_by_user")
public class Answers_by_UserController {
	
	@Autowired
	Answers_by_UserService answers_by_userService;
	
	@Autowired
	ResultMapper resultMapper;
	
	@Autowired
	Answers_by_UserMapper answers_by_userMapper;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResultDTO finishTest(@RequestBody List<Answers_by_UserDTO> dtos) throws EmptyFieldException, BadAnswersException, BadFieldsException, NotFoundException, TooManyFieldsException, NotEnoughFieldsException {
		return resultMapper.modelToDto(answers_by_userService.submitTest(answers_by_userMapper.dtoToModel(dtos)));
	}

}
