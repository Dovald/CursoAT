package com.dovald.CursoAT.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Result;

@Repository
public interface ResultDAO extends PagingAndSortingRepository<Result, Integer>{

}
