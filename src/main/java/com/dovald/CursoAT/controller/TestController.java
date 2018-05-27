package com.dovald.CursoAT.controller;

import java.util.Optional;
import java.util.Set;

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
import com.dovald.CursoAT.exception.DuplicatedKeyException;
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
	public Set<TestDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Test> tests = testService.findAll(PageRequest.of(page, size));
		return testMapper.modelToDto(tests);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public TestDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Test> test = testService.findById(id);
		if(!test.isPresent()) throw new NotFoundException();
		return testMapper.modelToDto(test.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public TestDTO create(@RequestBody TestDTO dto) throws DuplicatedKeyException {
		final Test test = testMapper.dtoToModel(dto);
		final Optional<Test> test1 = testService.findOneByName(test.getName());
		if(test1.isPresent()) throw new DuplicatedKeyException();
		final Test createTest = testService.create(test);
		return testMapper.modelToDto(createTest);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer id,@RequestBody TestDTO dto) throws NotFoundException, DuplicatedKeyException {
		final Optional<Test> test = testService.findById(id);
		if(!test.isPresent()) throw new NotFoundException();
		final Test test1 = testMapper.dtoToModel(dto);
		if(test1.getName() == test.get().getName()) throw new DuplicatedKeyException();
		test.get().setName(test1.getName());
		testService.update(test.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Test> test = testService.findById(id);
		if(!test.isPresent()) throw new NotFoundException();
		testService.delete(test.get());
	}

}
