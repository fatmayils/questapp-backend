package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.project.questapp.entities.Comment;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;
import com.project.questapp.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentsController {

	private CommentService commentService;
	public CommentsController(CommentService commentService) {
		this.commentService=commentService;
	}
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long>userId,@RequestParam Optional<Long>postId) {
		return commentService.getAllCommentsWithParam(userId,postId);
		
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId) {
		return commentService.getOneCommentById(commentId);
	}
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest newComment) {
		return commentService.createOneComment(newComment);
		
	}
	
	@PutMapping("/{commentId}")
	public Comment updatOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateRequest newComment)
	{
		return commentService.updateOneCommentById(commentId,newComment);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteOneComment(@PathVariable Long commentId) {
		
		commentService.deleteOneCommentById(commentId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
