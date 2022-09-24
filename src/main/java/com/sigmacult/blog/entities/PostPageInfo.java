package com.sigmacult.blog.entities;

import java.util.List;

import lombok.Data;

@Data
public class PostPageInfo {
	List<Post> content;
	Integer pageNumber;
	Integer pageSize;	
	Long totalElements;
	Integer totalPages;
	Boolean isLastPage;
}
