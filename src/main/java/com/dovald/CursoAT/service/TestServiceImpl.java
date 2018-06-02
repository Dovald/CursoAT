package com.dovald.CursoAT.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.TestDAO;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.model.Test;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestDAO testdao;
	
	@Autowired
	CourseService courseService;

	@Override
	public Test create(Test t) {
		return testdao.save(t);
	}

	@Override
	public void update(Test t) {
		testdao.save(t);
	}

	@Override
	public Optional<Test> findById(Integer id) {
		return testdao.findById(id);
	}

	@Override
	public List<Test> findAll(Pageable p) {
		return testdao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Test t) {
		testdao.delete(t);
	}

	@Override
	public Optional<Test> findOneByName(String name) {
		return testdao.findOneByName(name);
	}

	@Override
	public List<Test> findByCourse(Integer id,Pageable p) {
		return testdao.findByCourse(courseService.findById(id).get(),PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public Optional<Test> findTestById(Integer id, Integer idUser) throws NotFoundException {
		Optional<Test> test = testdao.findById(id);
		if(!test.isPresent()) throw new NotFoundException();
		Collections.shuffle(test.get().getQuestion());
		test.get().getQuestion().forEach(q -> Collections.shuffle(q.getAnswer()));
		return test;
	}

	@Override
	public Optional<Test> findTestByIdandNumber(Integer id, Integer number) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
