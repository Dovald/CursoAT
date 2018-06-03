package com.dovald.CursoAT.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.AnswerDAO;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Answer;
import com.dovald.CursoAT.model.Question;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerDAO answerdao;
	
	@Autowired
	QuestionService questionservice;

	@Override
	public Answer create(Answer t) {
		return answerdao.save(t);
	}
	
	@Override
	public List<Answer> create(List<Answer> answers) {
		final List<Answer> answers1 = new ArrayList<Answer>();
		answers.forEach(m -> answers1.add(create(m)));
		return answers1;
	}

	@Override
	public void update(Answer t) {
		answerdao.save(t);		
	}

	@Override
	public Optional<Answer> findById(Integer id) {
		return answerdao.findById(id);
	}

	@Override
	public List<Answer> findAll(Pageable p) {
		return answerdao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Answer t) {
		answerdao.delete(t);		
	}

	@Override
	public List<Answer> findByQuestion(Integer idQuestion) throws NotFoundException {
		final Optional<Question> q = questionservice.findById(idQuestion);
		if(!q.isPresent()) throw new NotFoundException();
		return answerdao.findByQuestion(q.get());
	}

}
