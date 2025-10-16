package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Article;
import com.example.demo.domain.ArticleTag;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.CommentMapper;

@Service
public class ArticleService {
     private final ArticleMapper articleMapper;
     private final CommentMapper commentMapper;

	 public ArticleService(ArticleMapper articleMapper, CommentMapper commentMapper) {
		this.articleMapper = articleMapper;
		this.commentMapper = commentMapper;
	}

	 public void writeArticle(String subject, String contents, String author, Long userId) {
	        Article article = new Article(subject, contents, author, userId);
	        articleMapper.insertArticle(article);
	 }
	 
	 public List<Article> getAllArticles(){
		 return articleMapper.getAllArticles();
	 }
	 
	 public Article getArticleById(Long id) {
//		 Article article = articleMapper.getArticleById(id);
//		 article.setComments(commentMapper.getCommentsByArticleId(id));
		 return articleMapper.getArticleById(id);
		 //return article;
	 }
	 
	 public void updateArticle(Long id, String subject, String contents, Long  userId) {
		 Article article = articleMapper.getArticleById(id);
		 
		 if(article == null || !article.isAuthor(userId)) {
			 throw new IllegalStateException("글을 수정할 수 없습니다.");
		  }
		 
		  articleMapper.updateArticle(id, subject, contents);
	  }
	 
	 public void deleteArticle(Long id, Long  userId) {
		 Article article = articleMapper.getArticleById(id);
		 
		 if(article == null || !article.isAuthor(userId)) {
			 throw new IllegalStateException("글을 삭제할 수 없습니다.");
		  }
		 
		  articleMapper.deleteArticle(id);
	  }

	 //tag와 join한 게시글
	 public ArticleTag getArticleWithTagById(Long id) {
		return articleMapper.getArticleWithTagById(id);
	 }
	 

}
