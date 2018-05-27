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

import com.dovald.CursoAT.component.mapper.answer.AnswerMapper;
import com.dovald.CursoAT.dto.AnswerDTO;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Answer;
import com.dovald.CursoAT.service.AnswerService;

@RestController
@RequestMapping(value = "/answer")
public class AnswerController {
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	AnswerMapper answerMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<AnswerDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Answer> answers = answerService.findAll(PageRequest.of(page, size));
		return answerMapper.modelToDto(answers);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public AnswerDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Answer> answer = answerService.findById(id);
		if(!answer.isPresent()) throw new NotFoundException();
		return answerMapper.modelToDto(answer.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public AnswerDTO create(@RequestBody AnswerDTO dto) {
		final Answer answer = answerMapper.dtoToModel(dto);
		final Answer createAnswer = answerService.create(answer);
		return answerMapper.modelToDto(createAnswer);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer id,@RequestBody AnswerDTO dto) throws NotFoundException {
		final Optional<Answer> answer = answerService.findById(id);
		if(!answer.isPresent()) throw new NotFoundException();
		final Answer answer1 = answerMapper.dtoToModel(dto);
		answer.get().setText(answer1.getText());
		answerService.update(answer.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Answer> answer = answerService.findById(id);
		if(!answer.isPresent()) throw new NotFoundException();
		answerService.delete(answer.get());
	}

}
