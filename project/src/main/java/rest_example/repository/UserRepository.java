package rest_example.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rest_example.model.User;

/**
 * @author jelena.nikolic
 *
 */

public interface UserRepository extends Repository<User, Long> {
	
	List<User> findAll();
	
	User findOne(Long id);
	
	User save(User user);
	
	void delete(User user);
	
}
