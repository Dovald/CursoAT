package com.dovald.CursoAT.service;

import java.util.Optional;

import com.dovald.CursoAT.model.Difficulty;

public interface DifficultyService extends AbstractCRUDService<Difficulty, Integer> {
	
	Optional<Difficulty> findOneByName(String name);

}
