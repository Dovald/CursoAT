package com.dovald.CursoAT.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dovald.CursoAT.model.Test;

public interface TestService extends AbstractCRUDService<Test, Integer> {

	List<Test> findByCourse(Integer id,Pageable p);
}
