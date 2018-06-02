package com.dovald.CursoAT.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.DifficultyDAO;
import com.dovald.CursoAT.model.Difficulty;

@Service
public class DifficultyServiceImpl implements DifficultyService {
	
	@Autowired
	DifficultyDAO difficultydao;

	@Override
	public Difficulty create(Difficulty t) {
		return difficultydao.save(t);
	}

	@Override
	public void update(Difficulty t) {
		difficultydao.save(t);
	}

	@Override
	public Optional<Difficulty> findById(Integer id) {
		return difficultydao.findById(id);
	}

	@Override
	public List<Difficulty> findAll(Pageable p) {
		return difficultydao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Difficulty t) {
		difficultydao.delete(t);
	}

	@Override
	public Optional<Difficulty> findOneByName(String name) {
		return difficultydao.findOneByName(name);
	}

}
