package dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer> {

	Optional<User> findOneByNameOrderByIdUserDesc(String name);

}
