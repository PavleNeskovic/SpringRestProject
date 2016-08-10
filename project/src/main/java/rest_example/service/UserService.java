/**
 * 
 */
package rest_example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest_example.dto.UserDto;
import rest_example.model.User;
import rest_example.repository.UserRepository;

/**
 * @author jelena.nikolic
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDto createUser(UserDto userToCreate) {
		User created = userRepository.save(new User(userToCreate));
		
		return created.transferToDto();
	}
	
	public void updateUser(UserDto dto) {
		User user = userRepository.findOne(dto.getId());
		
		if (user != null) {
			user.updateFromDto(dto);
			userRepository.save(user);
		}
	}
	
	public UserDto getUser(Long id) {
		UserDto response = null;
		
		User User = userRepository.findOne(id);
		if (User != null) {
			response = User.transferToDto();
		}
		
		return response;
	}
	
	public List<UserDto> getAll() {
		
		List<User> users = userRepository.findAll();
		
		List<UserDto> response = new ArrayList<UserDto>();
		
		for (User user : users) {
			response.add(user.transferToDto());
		}
		
		return response;
	}
	
	public void deleteUser(Long id) {
		User user = userRepository.findOne(id);
		
		if (user != null) {
			userRepository.delete(user);
		}
	}
	
}
