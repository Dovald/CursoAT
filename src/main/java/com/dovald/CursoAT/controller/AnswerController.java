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
import com.dovald.CursoAT.exception.TrueException;
import com.dovald.CursoAT.model.Answer;
import com.dovald.CursoAT.service.AnswerService;

@RestController
@RequestMapping(value = "/question/{idQuestion}/answer")
public class AnswerController {
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	AnswerMapper answerMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AnswerDTO> findAll(@PathVariable Integer idQuestion) {
		final List<Answer> answers = answerService.findByQuestion(idQuestion);
		return answerMapper.modelToDto(answers);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public AnswerDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Answer> answer = answerService.findById(id);
		if(!answer.isPresent()) throw new NotFoundException();
		return answerMapper.modelToDto(answer.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public AnswerDTO create(@PathVariable Integer idQuestion,@RequestBody AnswerPostDTO dto) throws MaxNumberException, TrueException, EmptyFieldException{
		dto.setIdQuestion(idQuestion);
		if(dto.getText() == null) throw new EmptyFieldException();
		if(answerService.findByQuestion(idQuestion).size() == 4) throw new MaxNumberException();
		if(answerService.findOneByIsCorrect(true).isPresent() && dto.isCorrect) throw new TrueException();
		final Answer answer = answerMapper.dtoToModel(dto);
		final Answer createAnswer = answerService.create(answer);
		return answerMapper.modelToDto(createAnswer);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void update(@PathVariable Integer idQuestion,@PathVariable Integer id,@RequestBody AnswerPostDTO dto) throws NotFoundException, TrueException {
		dto.setIdQuestion(idQuestion);
		final Optional<Answer> answer = answerService.findById(id);
		if(!answer.isPresent()) throw new NotFoundException();
		if(answerService.findOneByIsCorrect(true).isPresent() && dto.isCorrect) throw new TrueException();
		final Answer answer1 = answerMapper.dtoToModel(dto);
		if(answer1.getText() != null) answer.get().setText(answer1.getText());
		if(answer1.isCorrect() != answer.get().isCorrect()) answer.get().setCorrect(answer1.isCorrect());
		answerService.update(answer.get());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Answer> answer = answerService.findById(id);
		if(!answer.isPresent()) throw new NotFoundException();
		answerService.delete(answer.get());
	}

}
