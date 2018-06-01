package com.dovald.CursoAT.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Answers_by_User;

@Repository
public interface Answers_by_UserDAO extends PagingAndSortingRepository<Answers_by_User, Integer> {

}
