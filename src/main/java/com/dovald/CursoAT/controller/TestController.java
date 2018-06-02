package com.dovald.CursoAT.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dovald.CursoAT.component.mapper.test.TestMapper;
import com.dovald.CursoAT.dto.TestDTO;
import com.dovald.CursoAT.dto.TestGetDTO;
import com.dovald.CursoAT.dto.TestPostDTO;
import com.dovald.CursoAT.dto.TestPutDTO;
import com.dovald.CursoAT.exception.EmptyFieldException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Test;
import com.dovald.CursoAT.service.TestService;

@RestController
@RequestMapping(value = "/test")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@Autowired
	TestMapper testMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<TestDTO> findAll(@RequestParam(required = false) Integer idCourse,
			@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		List<Test> tests = new ArrayList<Test>();
		if(idCourse != null) { tests = testService.findByCourse(idCourse,PageRequest.of(page, size));}
		if(idCourse == null) { tests = testService.findAll(PageRequest.of(page, size));}
		return testMapper.modelToDto(tests);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public TestGetDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Test> test = testService.findById(id);
		if(!test.isPresent()) throw new NotFoundException();
		return testMapper.modelToGetDto(test.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public TestDTO create(@RequestBody TestPostDTO dto) throws EmptyFieldException {
		if(dto.getName() == null) throw new EmptyFieldException();
		final Test test = testMapper.dtoToModel(dto);
		final Test createTest = testService.create(test);
		return testMapper.modelToDto(createTest);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer id,@RequestBody TestPutDTO dto) throws NotFoundException {
		final Optional<Test> test = testService.findById(id);
		if(!test.isPresent()) throw new NotFoundException();
		final Test test1 = testMapper.dtoToModel(dto);
		if(test1.getName() != null) test.get().setName(test1.getName());
		if(test1.getCourse() != null) test.get().setCourse(test1.getCourse());
		if(!test1.getQuestion().isEmpty()) test.get().getQuestion().addAll(test1.getQuestion());
		testService.update(test.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Test> test = testService.findById(id);
		if(!test.isPresent()) throw new NotFoundException();
		testService.delete(test.get());
	}

}
