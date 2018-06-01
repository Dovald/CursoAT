package com.dovald.CursoAT.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Answer;
import com.dovald.CursoAT.model.Question;

@Repository
public interface AnswerDAO extends PagingAndSortingRepository<Answer, Integer>{
	
	List<Answer> findByQuestion(Question q);
	Optional<Answer> findOneByIsCorrect(boolean b);

}
