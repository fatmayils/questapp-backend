package com.project.questapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.PostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.responses.PostResponse;

@Service
public class PostService {
	private PostRepository postRepository;

	private UserService userService;

	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<PostResponse> getAllPost(Optional<Long> userId) {
		List<Post> list;
		if (userId.isPresent()) {
			 list=postRepository.findByUserId(userId.get());
		}
		else {
		 list=postRepository.findAll();}
		return list.stream().map(p->new PostResponse(p)).collect(Collectors.toList());
	}

	public Post getOnePostById(Long postId) {

		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostCreateRequest) {
		User user = userService.getOneUserById(newPostCreateRequest.getUserId());
		if (user == null) {
			return null;
		}
		Post toSave = new Post();
		toSave.setId(newPostCreateRequest.getId());
		toSave.setText(newPostCreateRequest.getText());
		toSave.setTitle(newPostCreateRequest.getTittle());
		toSave.setUser(user);
		return postRepository.save(toSave);
	}

	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if (post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTittle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);

	}

}
