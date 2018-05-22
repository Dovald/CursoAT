package com.dovald.CursoAT.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.ResultDAO;
import com.dovald.CursoAT.model.Result;

@Service
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	ResultDAO resultdao;

	@Override
	public Result create(Result t) {
		return resultdao.save(t);
	}

	@Override
	public void update(Result t) {
		resultdao.save(t);
	}

	@Override
	public Optional<Result> findById(Integer id) {
		return resultdao.findById(id);
	}

	@Override
	public Set<Result> findAll(Pageable p) {
		return resultdao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Result t) {
		resultdao.delete(t);
	}

}
