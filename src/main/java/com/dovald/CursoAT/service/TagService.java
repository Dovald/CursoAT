package com.dovald.CursoAT.service;

import java.util.Optional;

import com.dovald.CursoAT.model.Tag;

public interface TagService extends AbstractCRUDService<Tag, Integer> {
	
	Optional<Tag> findOneByName(String name);

}
