package com.dovald.CursoAT.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dovald.CursoAT.model.Course;

@Repository
public interface CourseDAO extends PagingAndSortingRepository<Course, Integer>{

}
