package com.dovald.CursoAT.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.TagDAO;
import com.dovald.CursoAT.model.Tag;

@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	TagDAO tagdao;

	@Override
	public Tag create(Tag t) {
		return tagdao.save(t);
	}

	@Override
	public void update(Tag t) {
		tagdao.save(t);
	}

	@Override
	public Optional<Tag> findById(Integer id) {
		return tagdao.findById(id);
	}

	@Override
	public Set<Tag> findAll(Pageable p) {
		return tagdao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}
	
	@Override
	public Optional<Tag> findOneByName(String name) {
		return tagdao.findOneByName(name);
	}

	@Override
	public void delete(Tag t) {
		tagdao.delete(t);
	}

}
