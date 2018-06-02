package com.dovald.CursoAT.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Result;
import com.dovald.CursoAT.model.Test;

@Repository
public interface ResultDAO extends PagingAndSortingRepository<Result, Integer>{

	List<Result> findByTest(Test test, Pageable p);

}
