package com.example.demo.domain;

import java.util.List;

public class ArticleTag {
	 private Long id;
	 private String subject;
	 private String contents;
	 
	 public String getContents() {
		return contents;
	}
	 public void setContents(String contents) {
		 this.contents = contents;
	 }
	 private List<Tag> tags;
	 
	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id = id;
	 }
	 
	 public String getSubject() {
		return subject;
	}
	 public void setSubject(String subject) {
		 this.subject = subject;
	 }
	
	 public List<Tag> getTags() {
		 return tags;
	 }
	 public void setTags(List<Tag> tags) {
		 this.tags = tags;
	 }
	 
	 

}
