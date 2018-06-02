package com.dovald.CursoAT.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.Answers_by_UserDAO;
import com.dovald.CursoAT.model.Answers_by_User;

@Service
public class Answers_by_UserServiceImpl implements Answers_by_UserService {
	
	@Autowired
	Answers_by_UserDAO answers_by_userdao;

	@Override
	public Answers_by_User create(Answers_by_User t) {
		return answers_by_userdao.save(t);
	}

	@Override
	public void update(Answers_by_User t) {
		answers_by_userdao.save(t);		
	}

	@Override
	public Optional<Answers_by_User> findById(Integer id) {
		return answers_by_userdao.findById(id);
	}

	@Override
	public List<Answers_by_User> findAll(Pageable p) {
		return answers_by_userdao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Answers_by_User t) {
		answers_by_userdao.delete(t);		
	}

}
