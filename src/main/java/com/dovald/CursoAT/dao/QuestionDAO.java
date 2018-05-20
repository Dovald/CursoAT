package com.dovald.CursoAT.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Question;

@Repository
public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer>{

}


