package com.dovald.CursoAT.service;

import java.util.List;
import java.util.Optional;

import com.dovald.CursoAT.model.Answer;

public interface AnswerService extends AbstractCRUDService<Answer, Integer> {
	
	List<Answer> findByQuestion(Integer idQuestion);
	Optional<Answer> findOneByIsCorrect(boolean b);
	List<Answer> create(List<Answer> answers);

}
