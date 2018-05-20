package com.dovald.CursoAT.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Answer;

@Repository
public interface AnswerDAO extends PagingAndSortingRepository<Answer, Integer>{

}
