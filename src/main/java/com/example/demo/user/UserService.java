package com.example.demo.user;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
		this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	public void joinUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		System.out.println("1.password:"+password);
		user.setPassword(passwordEncoder.encode(password)); //패스워드 암호화
		System.out.println("username:"+username);
		System.out.println("2.password:"+user.getPassword());
		userMapper.insertUser(user);
	}
}
