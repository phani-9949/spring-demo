package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Commet;
import com.example.demo.model.Post;
import com.example.demo.service.CommetService;
import com.example.demo.service.PostService;
@Controller
@RequestMapping("/social")
public class PostController {
	
	@Autowired
	private PostService ps;
	
	@Autowired
	private CommetService cs;
	
	
	  @GetMapping
	    public String viewPosts(Model model) {
	        model.addAttribute("posts", ps.getAllPost());
	        return "post";
	    }
	  @PostMapping("/new/post")
	    public String savePost(@ModelAttribute Post post) {
	      ps.savePost(post);
	        return "redirect:/post";
	    }
	  
	   @GetMapping("/new")
	   
		   public String showPostform(Model model)
		   {
			   model.addAttribute("post",new Post());
			   return "addapost";
		   }
	   
	      @PostMapping("/{postId}/commet")
	      
	    	  public String saveCommet(@PathVariable Long postId,@ModelAttribute Commet c)
	    	  {
	    		 cs.saveComment(postId, c);
	    		 return "redriect:/post";
	      }
	      
	   }
	
	
	
	
	
	
	


