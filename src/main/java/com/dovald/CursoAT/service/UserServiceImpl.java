package com.dovald.CursoAT.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dovald.CursoAT.dao.ResultDAO;
import com.dovald.CursoAT.dao.UserDAO;
import com.dovald.CursoAT.model.Result;
import com.dovald.CursoAT.model.User;

@Service
public class UserServiceImpl implements UserService, InitializingBean {

	@Autowired
	UserDAO userdao;
	
	@Autowired
	ResultDAO resultdao;

	@Override
	public void test() {
		final User u = new User();
		final Result r = new Result();
		final Result r1 = new Result();
		final List<Result> result = new ArrayList<Result>();
		u.setEmail("asd@g.com");
		u.setName("Pepe 1");
		u.setPassword("pepe123");
		userdao.save(u);
		r.setDate(new Date(0));
		r.setUser(u);
		r1.setDate(new Date(0));
		r1.setUser(u);
		resultdao.save(r);
		resultdao.save(r1);
		result.add(r);
		result.add(r1);		
		u.setResult(result);
		userdao.save(u);
		final Optional<User> user = userdao.findOneByNameOrderByIdDesc("Pepe 2");
		System.out.println(user.isPresent() ? user.get() : "no encontrado");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		test();
	}

}
