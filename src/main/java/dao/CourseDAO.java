package dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import model.Course;

@Repository
public interface CourseDAO extends PagingAndSortingRepository<Course, Integer>{

}
