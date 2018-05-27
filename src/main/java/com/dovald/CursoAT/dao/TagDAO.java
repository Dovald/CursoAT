package com.dovald.CursoAT.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Tag;

@Repository
public interface TagDAO extends PagingAndSortingRepository<Tag, Integer>{
	
	Optional<Tag> findOneByName(String name);

}
