package com.shubham.social.media.service;

import java.util.List;

import com.shubham.social.media.models.User;

public interface UserService {
	
	public User registerUser(User user);
	
	public User findUserById(int userId) throws Exception;
	
	public User findUserByEmail(String email);
	
	public User followUser(int userId1 , int userId2) throws Exception;
	
	public User updateUser(User user,int id) throws Exception;
	
	public List<User> searchUser(String query);
	
	public User findUserByJwt(String jwt);

}
