package dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import model.Test;

@Repository
public interface TestDAO extends PagingAndSortingRepository<Test, Integer>{

}
