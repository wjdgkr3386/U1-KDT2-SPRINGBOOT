package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Comment {
	 private Long id; //댓글 id
	 private Long articleId; //원글 id
	 private Long userId;
	 private String author;
	 private String content;
	 private LocalDateTime createdAt;
	 private LocalDateTime updatedAt;
	 
	 public boolean isAuthor(Long userId) {
		 return Objects.equals(this.userId, userId);
	 }
}
