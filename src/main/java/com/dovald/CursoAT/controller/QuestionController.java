package com.dovald.CursoAT.controller;

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

import com.dovald.CursoAT.component.mapper.question.QuestionMapper;
import com.dovald.CursoAT.dto.QuestionDTO;
import com.dovald.CursoAT.dto.QuestionPostDTO;
import com.dovald.CursoAT.exception.EmptyFieldException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Question;
import com.dovald.CursoAT.service.QuestionService;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Question> questions = questionService.findAll(PageRequest.of(page, size));
		return questionMapper.modelToDto(questions);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public QuestionDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Question> question = questionService.findById(id);
		if(!question.isPresent()) throw new NotFoundException();
		return questionMapper.modelToDto(question.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public QuestionPostDTO create(@RequestBody QuestionPostDTO dto) throws EmptyFieldException {
		if(dto.getText() == null) throw new EmptyFieldException();
		final Question question = questionMapper.dtoToModel(dto);
		final Question createQuestion = questionService.create(question);
		return questionMapper.modelToDtoPost(createQuestion);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer id,@RequestBody QuestionPostDTO dto) throws NotFoundException {
		final Optional<Question> question = questionService.findById(id);
		if(!question.isPresent()) throw new NotFoundException();
		final Question question1 = questionMapper.dtoToModel(dto);
		if(question1.getText() != null)question.get().setText(question1.getText());
		questionService.update(question.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Question> question = questionService.findById(id);
		if(!question.isPresent()) throw new NotFoundException();
		questionService.delete(question.get());
	}

}
