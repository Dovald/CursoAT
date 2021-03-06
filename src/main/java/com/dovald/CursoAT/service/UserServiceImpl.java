package com.dovald.CursoAT.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.UserDAO;
import com.dovald.CursoAT.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userdao;

	@Override
	public User create(User t) {
		return userdao.save(t);
	}

	@Override
	public void update(User t) {
		userdao.save(t);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userdao.findById(id);
	}

	@Override
	public List<User> findAll(Pageable p) {
		return userdao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toList());
	}
	
	@Override
	public Optional<User> findOneByName(String name) {
		return userdao.findOneByName(name);
	}

	@Override
	public void delete(User t) {
		userdao.delete(t);		
	}

	@Override
	public Optional<User> findOneByEmail(String name) {
		return userdao.findOneByEmail(name);
	}

}
