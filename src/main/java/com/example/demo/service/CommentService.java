package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Comment;
import com.example.demo.mapper.CommentMapper;

@Service
public class CommentService {
	private final CommentMapper commentMapper;

	public CommentService(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
	
	public void writeComment(Long articleId, Long userId, String author, String content) {
		Comment comment = new Comment(null,articleId, userId, author, content,null,null);
		commentMapper.insertComment(comment);
	}
	
	
	
}
