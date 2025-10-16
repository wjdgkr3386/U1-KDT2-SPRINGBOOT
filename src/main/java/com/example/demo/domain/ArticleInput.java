package com.example.demo.domain;

import jakarta.validation.constraints.NotBlank;

public class ArticleInput {
	    @NotBlank(message = "제목은 필수 입력 항목입니다.")
	    String subject;
	    @NotBlank(message = "내용은 필수 입력 항목입니다.")
	    String contents;
	    @NotBlank(message = "작성자는 필수 입력 항목입니다.")
	    String author;
	    
	    // Getter와 Setter
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
		
		@Override
		public String toString() {
			return "ArticleInput [subject=" + subject + ", contents=" + contents + ", author=" + author + "]";
		}

 
}
