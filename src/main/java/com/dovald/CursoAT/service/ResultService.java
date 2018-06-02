package com.dovald.CursoAT.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dovald.CursoAT.model.Result;

public interface ResultService extends AbstractCRUDService<Result, Integer> {

	List<Result> findByTest(Integer idTest, Pageable p);

}
