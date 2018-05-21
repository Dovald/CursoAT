package com.dovald.CursoAT.service;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Pageable;

public interface AbstractCRUDService<T, ID extends Serializable> {
	
	T create (T t);
	
	void update (T t);
	
	Optional<T> findById(Integer id);
	
	Set<T> findAll(Pageable p);
	
	void delete (T t);

}
