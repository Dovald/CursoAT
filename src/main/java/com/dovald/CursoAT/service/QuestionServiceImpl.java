package com.dovald.CursoAT.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.QuestionDAO;
import com.dovald.CursoAT.model.Question;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	QuestionDAO questiondao;

	@Override
	public Question create(Question t) {
		return questiondao.save(t);
	}

	@Override
	public void update(Question t) {
		questiondao.save(t);
	}

	@Override
	public Optional<Question> findById(Integer id) {
		return questiondao.findById(id);
	}

	@Override
	public List<Question> findAll(Pageable p) {
		return questiondao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Question t) {
		questiondao.delete(t);
	}

}
