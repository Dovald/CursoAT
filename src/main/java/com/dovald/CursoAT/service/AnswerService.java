package com.dovald.CursoAT.service;

import java.util.List;

import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Answer;

public interface AnswerService extends AbstractCRUDService<Answer, Integer> {
	
	List<Answer> findByQuestion(Integer idQuestion) throws NotFoundException;
	List<Answer> create(List<Answer> answers);

}
