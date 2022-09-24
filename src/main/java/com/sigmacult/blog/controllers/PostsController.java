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

import com.sigmacult.blog.entities.Post;
import com.sigmacult.blog.entities.PostDto;
import com.sigmacult.blog.entities.PostPageInfo;
import com.sigmacult.blog.repositories.PostRepoProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PostsController {
	@Autowired
	PostRepoProcessor postRepoProcessor;
	
	@PostMapping("posts")
	public Post addPost(@RequestBody PostDto postDto) {
		log.info("************" + postDto.toString());
		return postRepoProcessor.createPost(postDto);
	}
	
	@DeleteMapping("posts") 
	public boolean deletePost(@RequestParam String postId) {
		return postRepoProcessor.deletePost(postId);
	}
	
	@GetMapping("posts/all")
	public PostPageInfo getAllPost(@RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
		    @RequestParam(value = "sortByField", required = false, defaultValue = "addedDate") String sortByField,
			@RequestParam(value = "ascending", required = false, defaultValue = "false") Boolean ascending) {
		return postRepoProcessor.getAllPosts(pageNum - 1 < 0 ? 0 : pageNum - 1, pageSize, sortByField, ascending);
	}
	
	@GetMapping("posts")
	public Post getPost(@RequestParam String id) {
		return postRepoProcessor.getPost(id);
	}
	
	@PutMapping("posts") 
	public Post addPost(@RequestBody PostDto postDto, @RequestParam String id) {
		return postRepoProcessor.updatePost(id, postDto);
	}
	
	@GetMapping("/posts/search") 
	public List<Post> searchPostsByKeywords(@RequestParam String keywords) {
		return this.postRepoProcessor.searchPostsByKeywords(keywords);
	}
	
}
