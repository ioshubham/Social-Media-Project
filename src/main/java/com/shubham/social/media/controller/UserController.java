package com.shubham.social.media.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.social.media.exceptions.UserException;
import com.shubham.social.media.models.User;
import com.shubham.social.media.repository.UserRepository;
import com.shubham.social.media.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/api/users")
	public List<User> getUser() {
		
		List<User> users = userRepository.findAll();
			
		return users;
	}
	
	@GetMapping("/api/users/{userId}")
	public User getUserById(@PathVariable("userId") int id) throws UserException {
		User user = userService.findUserById(id);
		
		return user;
	}
	
	
	
	@PutMapping("/api/users")
	public User updateUser(@RequestBody User user,@RequestHeader("Authorization")String jwt) throws UserException {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		User userUpdate = userService.updateUser(user,reqUser.getId());
		
		return userUpdate;
	}
	
	@DeleteMapping("/api/users/{userId}")
	public String deleteUser(@PathVariable("userId") int id) throws UserException {
		
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserException("user does not exist with id "+id);
		}
		
		userRepository.delete(user.get());
		
		return "user deleted successfully with id "+id;
	}
	
	@PutMapping("/api/users/{userId2}")
	public User followUserHandeler(@RequestHeader("Authorization")String jwt ,@PathVariable Integer userId2) throws UserException {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		User user = userService.followUser(reqUser.getId(), userId2);
		
		return user;
	}
	
	@GetMapping("/api/users/search")
	public List<User> searchUser(@RequestParam("query") String query) {
		
		List<User> user = userService.searchUser(query);
		
		return user;
		
	}
	
	@GetMapping("/api/users/profile")
	public User getUserFromToken(@RequestHeader("Authorization")String jwt) {
		
		System.out.println("jwt------------"+jwt);
		
		User user = userService.findUserByJwt(jwt);
		
		user.setPassword(null);
		
		return user;
	}

}
