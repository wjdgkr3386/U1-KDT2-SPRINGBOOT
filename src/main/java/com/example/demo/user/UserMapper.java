package com.example.demo.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	
	@Insert("insert into user(username, password) values(#{username},#{password})")
	void insertUser(User user);
	
	@Select("select * from user where username = #{username}")
	User getUser(String username);
   
}
