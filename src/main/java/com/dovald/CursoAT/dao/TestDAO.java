package com.dovald.CursoAT.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Test;

@Repository
public interface TestDAO extends PagingAndSortingRepository<Test, Integer>{

}
