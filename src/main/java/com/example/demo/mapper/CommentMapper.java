package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Comment;

@Mapper
public interface CommentMapper {
	@Insert("""
			insert into comment (content, author, article_id, user_id)  
			 values( #{content},#{author},#{articleId},#{userId})
			""")
	void insertComment(Comment comment);
	
	@Select(" select * from comment where article_id=#{id}")
	List<Comment> getCommentsByArticleId(Long id);

}
