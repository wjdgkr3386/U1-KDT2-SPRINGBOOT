package com.example.demo.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	 
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public UserDetailsServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
		this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.getUser(username);
		if(user == null) throw new UsernameNotFoundException(username);
		return user;
	}
}
