package com.project.questapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Like;
import com.project.questapp.entities.User;
import com.project.questapp.repos.CommentRepository;
import com.project.questapp.repos.LikeRepository;
import com.project.questapp.repos.PostRepository;
import com.project.questapp.repos.UserRepository;


@Service
public class UserService {
	private UserRepository userRepository;

	private PostRepository postRepository;
	private CommentRepository commentRepository;
	private LikeRepository likeRepository;
	public UserService(UserRepository userRepository,PostRepository postRepository,CommentRepository commentRepository,
			LikeRepository likeRepository	) {
		this.userRepository = userRepository;
		this.postRepository=postRepository;
		this.likeRepository=likeRepository;
		this.commentRepository=commentRepository;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(User newUser) {
		return userRepository.save(newUser);
	}
	
	public User getOneUserById(Long userId) {
		// custom excepetion ekle
		return userRepository.findById(userId).orElse(null);//bulamassan null dön
	}
	
	public User updateOneUSer(Long userId,User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			foundUser.setAvatar(newUser.getAvatar());
			userRepository.save(foundUser);
			return foundUser;
		} else {
			return null;
		}
	}
	
	public void deleteOneUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public User getOneUserByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}

	public List<Object> getUserActivity(Long userId) {
	
		List<Long> postIds=postRepository.findTopByUserId(userId);
		if(postIds.isEmpty())
		{
			return null;
		}
		List<Object> comments=commentRepository.findUserCommentByPostId(postIds);
		List<Object> likes=likeRepository.findUserLikeByPostId(postIds);
		List<Object> result=new ArrayList<>();
		result.addAll(comments);
		result.addAll(likes);
		return result;
	}


}
