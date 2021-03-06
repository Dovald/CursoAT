package com.dovald.CursoAT.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dovald.CursoAT.component.mapper.result.ResultMapper;
import com.dovald.CursoAT.dto.ResultDTO;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Result;
import com.dovald.CursoAT.service.ResultService;

@RestController
@RequestMapping(value = "/result")
public class ResultController {
	
	@Autowired
	ResultService resultService;
	
	@Autowired
	ResultMapper resultMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ResultDTO> findAll(@RequestParam(required = false) Integer idTest,
			@RequestParam(required = false) Integer idUser,
			@RequestParam(required = false) Integer idCourse,
			@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		List<Result> results = new ArrayList<Result>();
		if(idTest != null) {results = resultService.findByTest(idTest,PageRequest.of(page, size));}
		if(idUser != null) {results = resultService.findByUser(idUser,PageRequest.of(page, size));}
		if(idCourse != null) {results = resultService.findByCourse(idCourse,PageRequest.of(page, size));}
		if(idTest == null && idUser == null && idCourse == null) {results = resultService.findAll(PageRequest.of(page, size));}
		return resultMapper.modelToDto(results);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResultDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Result> result = resultService.findById(id);
		if(!result.isPresent()) throw new NotFoundException();
		return resultMapper.modelToDto(result.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Result> result = resultService.findById(id);
		if(!result.isPresent()) throw new NotFoundException();
		resultService.delete(result.get());
	}

}
