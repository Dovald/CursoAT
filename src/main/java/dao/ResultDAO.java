package dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import model.Result;

@Repository
public interface ResultDAO extends PagingAndSortingRepository<Result, Integer>{

}
