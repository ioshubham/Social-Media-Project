package com.shubham.social.media.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
	
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	
	private String caption;
	private String image;
	private String video;
	
	@ManyToOne  // 1 user have multiple post
	private User user;
	
	private LocalDateTime createAt;
	
	@OneToMany  // 1 post can be like by many user
	private List<User> liked = new ArrayList<>();
	
	@OneToMany
	private List<Comment> comments = new ArrayList<>();
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int postId, String caption, String image, String video, User user, LocalDateTime createAt,
			List<User> liked, List<Comment> comments) {
		super();
		this.postId = postId;
		this.caption = caption;
		this.image = image;
		this.video = video;
		this.user = user;
		this.createAt = createAt;
		this.liked = liked;
		this.comments = comments;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public List<User> getLiked() {
		return liked;
	}

	public void setLiked(List<User> liked) {
		this.liked = liked;
	}

	
}
