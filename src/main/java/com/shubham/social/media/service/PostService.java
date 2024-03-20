package com.shubham.social.media.service;

import java.util.List;

import com.shubham.social.media.models.Post;

public interface PostService {
	
	Post createNewPost(Post post ,int userId) throws Exception;
	
	String deletePost(int postId , int userId) throws Exception;
	
	List<Post> findPostsByUserId(int user_id) throws Exception;
	
	Post findPostById(int postId) throws Exception;
	
	List<Post> findAllPost() throws Exception;
	
	Post savedPost(int postId,int userId) throws Exception;
	
	Post likePost(int postId , int userId) throws Exception;
	
	Post updatePostById(int postId, int userId) throws Exception;

}
