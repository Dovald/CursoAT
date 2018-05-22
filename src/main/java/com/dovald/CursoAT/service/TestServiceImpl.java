package com.dovald.CursoAT.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.TestDAO;
import com.dovald.CursoAT.model.Test;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestDAO testdao;

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
	public Set<Test> findAll(Pageable p) {
		return testdao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Test t) {
		testdao.delete(t);
	}

}
