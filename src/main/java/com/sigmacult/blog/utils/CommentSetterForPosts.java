package com.sigmacult.blog.utils;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sigmacult.blog.entities.Comment;
import com.sigmacult.blog.entities.Post;
import com.sigmacult.blog.repositories.CommentRepo;
import com.sigmacult.blog.repositories.PostRepo;
import com.sigmacult.blog.repositories.PostRepoProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommentSetterForPosts {
	
	@Autowired
	static CommentRepo commentRepo;
	
	@Autowired
	static PostRepoProcessor postRepoProcessor;
	static PostRepo postRepo;
	
	public static void updateCommentsForPost(String postId) {
		log.info(postId);
		try {
			Post post = postRepoProcessor.getPost(postId);
//			if(post == null) {
//				log.info("post not found");	
//				return;
//			}
//			log.info(post.get().toString());
//			List<Comment> loc = commentRepo.findByPostId(postId);
//			log.info(loc.toString());
//			post.get().setComments(loc);
		} catch(Exception e) {
			log.error(e.toString());
		}
	}	
}
