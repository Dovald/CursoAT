package com.dovald.CursoAT.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.CourseDAO;
import com.dovald.CursoAT.model.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseDAO coursedao;

	@Override
	public Course create(Course t) {
		return coursedao.save(t);
	}

	@Override
	public void update(Course t) {
		coursedao.save(t);
	}

	@Override
	public Optional<Course> findById(Integer id) {
		return coursedao.findById(id);
	}

	@Override
	public Set<Course> findAll(Pageable p) {
		return coursedao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Course t) {
		coursedao.delete(t);
	}

}
