package com.dovald.CursoAT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dovald.CursoAT.component.mapper.answers_by_user.Answers_by_UserMapper;
import com.dovald.CursoAT.component.mapper.result.ResultMapper;
import com.dovald.CursoAT.component.mapper.test.TestMapper;
import com.dovald.CursoAT.dto.Answers_by_UserDTO;
import com.dovald.CursoAT.dto.ResultDTO;
import com.dovald.CursoAT.dto.TestGetDTO;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Answers_by_User;
import com.dovald.CursoAT.model.Test;
import com.dovald.CursoAT.service.Answers_by_UserService;
import com.dovald.CursoAT.service.TestService;

@RestController
@RequestMapping(value = "/dotest/{idTest}/user")
public class DoTestController {
	
	@Autowired
	TestService testService;
	
	@Autowired
	Answers_by_UserService answers_by_userService;
	
	@Autowired
	TestMapper testMapper;
	
	@Autowired
	ResultMapper resultMapper;
	
	@Autowired
	Answers_by_UserMapper answers_by_userMapper;
	
	@RequestMapping(value = "/{idUser}",method = RequestMethod.GET)
	public TestGetDTO findById(@PathVariable Integer idTest,@PathVariable Integer idUser) throws NotFoundException {
		final Optional<Test> test = testService.findTestById(idTest,idUser);
		if(!test.isPresent()) throw new NotFoundException();
		return testMapper.modelToGetDto(test.get());
	}
	
	@RequestMapping(value = "/{idUser}",method = RequestMethod.POST)
	public ResultDTO finishGlobalTest(@PathVariable Integer idTest,@PathVariable Integer idUser,@RequestBody List<Answers_by_UserDTO> dtos) throws NotFoundException {
		final Optional<Test> test = testService.findTestById(idTest,idUser);
		if(!test.isPresent()) throw new NotFoundException();
		final List<Answers_by_User> list = answers_by_userMapper.dtoToModel(idTest,idUser,dtos);
		return resultMapper.modelToDto(answers_by_userService.submitTest(list));
	}

}
