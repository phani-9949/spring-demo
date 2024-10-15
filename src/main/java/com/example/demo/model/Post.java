package com.example.demo.model;

import java.util.List;

//import javax.xml.stream.events.Comment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	private String content;
	
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	
	private List<Commet> comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Commet> getComments() {
		return comments;
	}

	public void setComments(List<Commet> comments) {
		this.comments = comments;
	}
	
	
	
	

}
