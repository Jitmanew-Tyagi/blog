package com.sigmacult.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sigmacult.blog.entities.Comment;
import com.sigmacult.blog.repositories.CommentRepoProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CommentController {
	
	@Autowired
	CommentRepoProcessor commentRepoProcessor;
	
	@PostMapping("/comment")
	public Comment addComment(@RequestBody Comment comment) {
		log.info("THIS ONE" + comment.toString());
		return commentRepoProcessor.addComment(comment);
	}
	
	@PutMapping("/comment")
	public Comment updateComment(@RequestBody Comment comment) {
		return commentRepoProcessor.updateComment(comment);
	}
	
	@GetMapping("/postComments")
	public List<Comment> getAllCommentsForPost(@RequestParam String id) {
		return null;
	}
	
	@DeleteMapping("/comment")
	public boolean deleteComment(@RequestParam String id) {
		return commentRepoProcessor.deleteComment(id);
	}
	
}
