package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Commet;
import com.example.demo.model.Post;
import com.example.demo.repository.CommetRepository;

@Service
public class CommetService {
	@Autowired
	private CommetRepository cp;
	
	 @Autowired
	    private PostService postService;

	    public Commet saveComment(Long postId, Commet commet) {
	        Post post = postService.getPostById(postId);
	        if (post != null) {
	            commet.setPost(post);
	            return cp.save(commet);
	        }
	        return null;
	    }
	
	

}
