package com.example.demo.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Article {
    private Long id;
    private String subject;

	private String contents;
    private String author;
    private Instant createdAt;
    private Instant updatedAt;
    private Long  userId;
    private int commentCount;
    private List<Tag> tags;
    
    private List<Comment> comments  = new ArrayList<>();

    public boolean isAuthor(Long userId) {
    	return Objects.equals(this.userId, userId);//두객체가 동등하면 true/false
    }
//    public Article(String subject, String contents, String author) {
//        this.subject = subject;
//        this.contents = contents;
//        this.author = author;
//        this.createdAt = Instant.now();
//    }
   
    
    public Article(String subject, String contents, String author, Long userId) {
		this.subject = subject;
		this.contents = contents;
		this.author = author;
		this.userId = userId;
		this.createdAt = Instant.now();
	}
    
    



	// Getter 메소드
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", subject=" + subject + ", contents=" + contents + ", author=" + author
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	public List<Comment> getComments() {
		return comments;
	}
	
	public void addComments(Comment comment) {
		this.comments.add(comment);
	}
	
	
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
    
}