package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.Like;
import com.project.questapp.repos.LikeRepository;
import com.project.questapp.requests.LikeCreateRequest;
import com.project.questapp.services.LikeService;

@RestController
@RequestMapping("/likes")
public class LikesController {

	private LikeService likeService;
	public LikesController (LikeService likeService) {
	this.likeService=likeService;
	}
	@GetMapping
	public List<Like> getAllLikes(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId){
		return likeService.getAllLikesWithParam(userId,postId);
	}
	
	@GetMapping("/{likeId}")
	public Like getOneLike(@PathVariable Long likeId)
	{
		return likeService.getOneLikeById(likeId);
	}
	
	@PostMapping
	public Like createOneLike(@RequestBody LikeCreateRequest newLike) {
		return likeService.createOneLike(newLike);
	}
	@DeleteMapping("/{likeId}")
	public void deleteOneLike(@PathVariable Long likeId) {
		likeService.deleteOneLikeById(likeId);
	}
	
}
