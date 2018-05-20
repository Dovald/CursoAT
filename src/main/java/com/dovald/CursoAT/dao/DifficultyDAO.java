package com.dovald.CursoAT.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Difficulty;

@Repository
public interface DifficultyDAO extends PagingAndSortingRepository<Difficulty, Integer>{

}
