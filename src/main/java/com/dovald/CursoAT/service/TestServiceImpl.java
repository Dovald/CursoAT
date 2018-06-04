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
import com.dovald.CursoAT.model.Question;
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
		Optional<Test> test = testdao.findById(id);
		if(test.get().getQuestion() != null) 
		{
			Collections.shuffle(test.get().getQuestion());
			test.get().getQuestion().forEach(q -> Collections.shuffle(q.getAnswer()));
		}
		return test;
	}
	
	@Override
	public Optional<Test> findById(Integer id, Integer index) {
		Optional<Test> test = testdao.findById(id);
		test.get().getQuestion().forEach(q -> Collections.shuffle(q.getAnswer()));
		Question q = new Question();
		q = test.get().getQuestion().get(index);
		test.get().getQuestion().clear();
		test.get().getQuestion().add(q);
		return test;
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
	public List<Test> findByCourse(Integer id,Pageable p) {
		return testdao.findByCourse(courseService.findById(id).get(),PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public Optional<Test> findByID(Integer id) {
		return testdao.findById(id);
	}

}
