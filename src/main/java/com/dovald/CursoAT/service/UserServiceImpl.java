package com.dovald.CursoAT.service;

import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.UserDAO;
import com.dovald.CursoAT.model.User;

@Service
public class UserServiceImpl implements UserService, InitializingBean {

	@Autowired
	UserDAO dao;

	@Override
	public void test() {
		final User u = new User();
		u.setEmail("asd@g.com");
		u.setName("Pepe 1");
		u.setPassword("pepe123");
		dao.save(u);
		final Optional<User> user = dao.findOneByNameOrderByIdDesc("Pepe 2");
		System.out.println(user.isPresent() ? user.get() : "no encontrado");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		test();
	}

}
