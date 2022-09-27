package com.sigmacult.blog.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sigmacult.blog.entities.Post;
import com.sigmacult.blog.entities.PostDto;
import com.sigmacult.blog.entities.PostPageInfo;
import com.sigmacult.blog.utils.DtoToPostConverter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostRepoProcessor {
	
	@Autowired
	PostRepo postRepo; 
	
	@Autowired
	DtoToPostConverter dtoToPostConverter;
	
	public Post createPost(PostDto postDto) {
		Post post = dtoToPostConverter.dtoToPost(postDto);
		
		return postRepo.save(post);
	}
	
	public boolean deletePost(String id) {
		var status = false;
		try {
			postRepo.deleteById(id);
			status = true;
		} catch(Exception e) {
			log.error("Failed to delete post");
		}
		return status;
	}
	
	public PostPageInfo getAllPosts(Integer pageNum, Integer pageSize, String sortByField, boolean ascending) {
		PageRequest p = PageRequest.of(pageNum, pageSize, 
				ascending ? Sort.by(sortByField): Sort.by(sortByField).descending());
		Page<Post> pageOfPost =  postRepo.findAll(p);
		PostPageInfo postPageInfo = new PostPageInfo();
		postPageInfo.setContent(pageOfPost.getContent());
		postPageInfo.setPageNumber(pageOfPost.getNumber() + 1);
		postPageInfo.setPageSize(pageOfPost.getSize());
		postPageInfo.setTotalElements(pageOfPost.getTotalElements());   
		postPageInfo.setTotalPages(pageOfPost.getTotalPages());
		postPageInfo.setIsLastPage(pageOfPost.isLast());		
		return postPageInfo;
	}
	
	public Post getPost(String id) {
		Post post = null;
		post = postRepo.findById(id).orElse(null);
		System.out.print(post.toString());
		return post;
	}
	
	public Post updatePost(String id, PostDto postDto) {
		Post check = getPost(id);
		if(check == null) {
			log.info("Post doesn't exists, creating one");
		} else {
			deletePost(id);
		}
		return createPost(postDto);
	}
	
	public Post updatePost(String id, Post post) {
		Post check = getPost(id);
		if(check == null) {
			log.info("Post doesn't exists, creating one");
		} else {
			check = postRepo.save(post);
		}
		return check;
	}
	
	public List<Post> searchPostsByKeywords(String keywords){
		return postRepo.findByTitleContaining(keywords);
	}
}
