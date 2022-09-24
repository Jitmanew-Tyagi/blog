package com.sigmacult.blog.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmacult.blog.entities.Comment;
import com.sigmacult.blog.utils.CommentSetterForPosts;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommentRepoProcessor {
	
	@Autowired
	CommentRepo commentRepo;
	public Comment addComment(Comment comment) {
		Comment savedComment =  commentRepo.save(comment);
		log.info(savedComment.toString() + "%%%");
		CommentSetterForPosts.updateCommentsForPost(comment.getPostId());
		return savedComment;
	}
	
	public boolean deleteComment(String id) {
		boolean status = false;
		try {
			commentRepo.deleteById(id);
			status = true;
		} catch(Exception e) {
			log.error(e.toString());
		}
		return status;
	}
	
	public Comment updateComment(Comment comment) {
		deleteComment(comment.getId());
		Comment savedComment = addComment(comment);
		CommentSetterForPosts.updateCommentsForPost(savedComment.getPostId());
		return savedComment;
	}
}
