package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Article;
import com.example.demo.domain.ArticleTag;
import com.example.demo.domain.Tag;

 // mapper컴포넌트
@Mapper
public interface ArticleMapper {
	 // SQL 쿼리와 매핑할 메서드를 정의
    void insertArticle(Article article);
    
    List<Article> getAllArticles();
    
    Article getArticleById(Long id);

    void updateArticle(Long id, String subject, String contents);
    void deleteArticle(Long id);
    
    
    @Select("""
            SELECT a.id, a.subject, a.contents
            FROM article a
            JOIN article_tag at ON a.id = at.article_id
            JOIN tag t ON at.tag_id = t.id
            WHERE a.id = #{id}
            """)
    @Results({
     @Result(property = "id",column="id"),
     @Result(property = "subject", column = "subject"),
     @Result(property = "contents", column = "contents"),
     @Result(property = "tags", column = "id", many = @Many(select = "selectTagsByArticleId"))
    })
    ArticleTag getArticleWithTagById(Long id);
     
     @Select("""
     		SELECT t.id, t.name
            FROM tag t
            JOIN article_tag at ON t.id = at.tag_id
            WHERE at.article_id = #{articleId}
     		""")
     List<Tag> selectTagsByArticleId(Long articleId);
}