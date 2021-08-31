package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.responses.PostResponse;
import com.project.questapp.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostsController {
	private PostService postService;

	public PostsController(PostService postService) {

		this.postService = postService;
	}

	@GetMapping
	public List<PostResponse> getAllPost(@RequestParam Optional<Long> userId) {
		return postService.getAllPost(userId);
	}

	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);

	}

	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createOnePost(newPostRequest);
	}

	@PutMapping("/{postId}")
	public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
		return postService.updateOnePostById(postId, updatePost);
	}

	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		postService.deleteOnePostById(postId);

	}
}
