package com.shubham.social.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shubham.social.media.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
	
	@Query("select DISTINCT u from User u where u.FirstName LIKE %:query% OR u.lastName LIKE %:query% OR u.email LIKE %:query%")
	public List<User> searchUser(@Param("query") String query);
	
	
	
	
	
	
	
	

}
