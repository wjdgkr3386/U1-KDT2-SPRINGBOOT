package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity //추가
public class SecurityConfig { 
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
        .authorizeHttpRequests(authorizeRequests ->
                               authorizeRequests.requestMatchers("/login","/register").permitAll()
                                                 .anyRequest().authenticated())//접근허용처리(로그인처리) 
        .formLogin(formLogin-> formLogin.loginPage("/login").permitAll()) //로그인방식-form방식
        .exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/accessDenied"));		
        
		 return http.build();
	}
}
