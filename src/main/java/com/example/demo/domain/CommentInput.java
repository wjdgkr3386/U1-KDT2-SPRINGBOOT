package com.example.demo.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentInput {
	Long articleId;
	
	@NotBlank(message="내용은 필수 입력 항목입니다.")
	String content;
}
