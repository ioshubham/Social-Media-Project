package com.shubham.social.media.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.social.media.models.Post;
import com.shubham.social.media.models.User;
import com.shubham.social.media.repository.PostRepository;
import com.shubham.social.media.repository.UserRepository;

@Service
public class PostServiceImplementation implements PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Post createNewPost(Post post, int userId) throws Exception {
		
		User user = userService.findUserById(userId);
				
		Post newPost = new Post();
		newPost.setCaption(post.getCaption());
		newPost.setCreateAt(LocalDateTime.now());
		newPost.setImage(post.getImage());
		newPost.setVideo(post.getVideo());
		newPost.setUser(user);
		
		postRepository.save(newPost);
		
		
		return newPost;
	}

	@Override
	public String deletePost(int postId, int userId) throws Exception {
		
		Post post = findPostById(postId);
		User user = userService.findUserById(userId);
		
		if(post.getUser().getId()!=user.getId()) {
			throw new Exception("You can't delete another users's post");
		}
		
		postRepository.delete(post);
		
		return "Post deleted succesfully";
	}

	@Override
	public List<Post> findPostsByUserId(int user_id) throws Exception {
		
		return postRepository.findPostByUserId(user_id);
	}

	@Override
	public List<Post> findAllPost() throws Exception {
		
		return postRepository.findAll();
	}

	@Override
	public Post savedPost(int postId, int userId) throws Exception {
		
		Post post = findPostById(postId);
		User user = userService.findUserById(userId);
		
		if(user.getSavedPost().contains(post)) {
			user.getSavedPost().remove(post);
		}
		else {
			user.getSavedPost().add(post);
		}
		userRepository.save(user);
		return post;
	}

	@Override
	public Post likePost(int postId, int userId) throws Exception {
		Post post = findPostById(postId);
		User user = userService.findUserById(userId);
		
		
		
		if(post.getLiked().contains(user)) {
			post.getLiked().remove(user);
		}
		else {
			post.getLiked().add(user);
			postRepository.save(post);
		}
		return post;
	}

	@Override
	public Post updatePostById(int postId, int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findPostById(int postId) throws Exception {
		Optional<Post> post = postRepository.findById(postId);
		
		if(post.isEmpty()) {
			throw new Exception("Post not found with id "+postId);
		}
		
		return post.get();
	}

}
