package com.shubham.social.media.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.social.media.config.JwtProvider;
import com.shubham.social.media.exceptions.UserException;
import com.shubham.social.media.models.User;
import com.shubham.social.media.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setId(user.getId());
		
		User savedUser = userRepository.save(newUser);
		
		return savedUser;
	}

	@Override
	public User findUserById(int userId) throws UserException {
		Optional<User> user = userRepository.findById(userId);	
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UserException("user not exists with userId"+userId);
	}

	@Override
	public User findUserByEmail(String email) {
		
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User followUser(int reqUserId, int userId2) throws UserException {
		
		User reqUser = findUserById(reqUserId);
		User user2 = findUserById(userId2);
		
		user2.getFollowers().add(reqUser .getId());
		reqUser .getFollowings().add(user2.getId());
		
		userRepository.save(reqUser );
		userRepository.save(user2);
		
		return reqUser ;
	}

	@Override
	public User updateUser(User user, int id) throws UserException {
		Optional<User> user1 = userRepository.findById(id);
		
		if(user1.isEmpty()) {
			throw new UserException("user does not exist with id "+id);
		}
		
		User oldUser = user1.get();
		
		if(user.getFirstName()!=null) {
			oldUser.setFirstName(user.getFirstName());
		}
		if(user.getLastName()!=null) {
			oldUser.setLastName(user.getLastName());
		}
		if(user.getEmail()!=null) {
			oldUser.setEmail(user.getEmail());
		}
		if(user.getPassword()!=null) {
			oldUser.setPassword(user.getPassword());
		}
		
		User updatedUser = userRepository.save(oldUser);
		
		return updatedUser;
	}

	@Override
	public List<User> searchUser(String query) {
		
		List<User> users = userRepository.searchUser(query);
		return users;
	}

	@Override
	public User findUserByJwt(String jwt) {
		String email = JwtProvider.getEmailFromJwtToken(jwt);
		
		User user = userRepository.findByEmail(email);
		return user;
	}

}
