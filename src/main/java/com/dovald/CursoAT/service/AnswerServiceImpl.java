package com.dovald.CursoAT.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.AnswerDAO;
import com.dovald.CursoAT.model.Answer;

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
	public List<Answer> findByQuestion(Integer idQuestion) {
		return answerdao.findByQuestion(questionservice.findById(idQuestion).get());
	}

	@Override
	public Optional<Answer> findOneByIsCorrect(boolean b) {
		return answerdao.findOneByIsCorrect(b);
	}

}
