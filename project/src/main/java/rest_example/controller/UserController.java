package rest_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest_example.dto.UserDto;
import rest_example.service.UserService;

/**
 * @author jelena.nikolic
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// create new user
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserDto user) {
		UserDto created = userService.createUser(user);
		return new ResponseEntity<>(created.getId(), HttpStatus.CREATED);
	}
	
	// update user
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
		user.setId(id);
		userService.updateUser(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// get user
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
		UserDto user = userService.getUser(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
		
	}
	
	// get all users
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> users = userService.getAll();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
		
	}
	
	// delete user
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/redirect")
	public ResponseEntity<String> redirection() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, "/jelena");
		return new ResponseEntity<String>(headers, HttpStatus.FOUND);
	}
}
