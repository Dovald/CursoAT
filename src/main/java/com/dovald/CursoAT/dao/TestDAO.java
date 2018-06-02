package com.dovald.CursoAT.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Course;
import com.dovald.CursoAT.model.Test;

@Repository
public interface TestDAO extends PagingAndSortingRepository<Test, Integer>{

	Optional<Test> findOneByName(String name);
	List<Test> findByCourse(Course course,Pageable p);
}
