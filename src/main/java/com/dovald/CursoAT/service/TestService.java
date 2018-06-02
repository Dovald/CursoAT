package com.dovald.CursoAT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Test;

public interface TestService extends AbstractCRUDService<Test, Integer> {

	Optional<Test> findOneByName(String name);
	List<Test> findByCourse(Integer id,Pageable p);
	Optional<Test> findTestById(Integer id, Integer idUser) throws NotFoundException;
	Optional<Test> findTestByIdandNumber(Integer id,Integer number) throws NotFoundException;

}
