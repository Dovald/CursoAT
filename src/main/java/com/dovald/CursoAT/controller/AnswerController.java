package com.dovald.CursoAT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dovald.CursoAT.component.mapper.answer.AnswerMapper;
import com.dovald.CursoAT.dto.AnswerDTO;
import com.dovald.CursoAT.dto.AnswerPostDTO;
import com.dovald.CursoAT.exception.EmptyFieldException;
import com.dovald.CursoAT.exception.MaxNumberException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.exception.TwoAnswersTrueException;
import com.dovald.CursoAT.model.Answer;
import com.dovald.CursoAT.service.AnswerService;

@RestController
public class AnswerController {
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	AnswerMapper answerMapper;
	
	@RequestMapping(value = "/answer/{id}",method = RequestMethod.GET)
	public AnswerDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Answer> answer = answerService.findById(id);
		if(!answer.isPresent()) throw new NotFoundException();
		return answerMapper.modelToDto(answer.get());
	}
	
	@RequestMapping(value = "/question/{idQuestion}/answer",method = RequestMethod.GET)
	public List<AnswerDTO> findAll(@PathVariable Integer idQuestion) {
		final List<Answer> answers = answerService.findByQuestion(idQuestion);
		return answerMapper.modelToDto(answers);
	}

	@RequestMapping(value = "/question/{idQuestion}/answer",method = RequestMethod.POST)
	public List<AnswerPostDTO> create(@PathVariable Integer idQuestion,@RequestBody List<AnswerPostDTO> dtos) throws MaxNumberException, TwoAnswersTrueException, EmptyFieldException{
		dtos.forEach(m -> m.setIdQuestion(idQuestion));
		List<Answer> list = answerService.findByQuestion(idQuestion);
		final List<Answer> answers = answerMapper.dtoPostToModel(dtos);
		list.addAll(answers);
		if(list.size() > 4) throw new MaxNumberException();
		int flag=0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getText() == null) throw new EmptyFieldException();
			if(list.get(i).isCorrect()) flag++;
			
		}
		if(flag > 1) throw new TwoAnswersTrueException();
		if(flag == 0) throw new TwoAnswersTrueException();
		return answerMapper.modelToPostDto(answerService.create(answers));
	}
	
	@RequestMapping(value = "/answer/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Answer> answer = answerService.findById(id);
		if(!answer.isPresent()) throw new NotFoundException();
		answerService.delete(answer.get());
	}

}
