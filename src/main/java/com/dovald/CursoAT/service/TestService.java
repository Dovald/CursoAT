package com.dovald.CursoAT.service;

import java.util.Optional;

import com.dovald.CursoAT.model.Test;

public interface TestService extends AbstractCRUDService<Test, Integer> {

	Optional<Test> findOneByName(String name);

}
