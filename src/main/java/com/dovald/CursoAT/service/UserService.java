package com.dovald.CursoAT.service;

import java.util.Optional;

import com.dovald.CursoAT.model.User;

public interface UserService extends AbstractCRUDService<User, Integer> {
	
	Optional<User> findOneByName(String name);

}
