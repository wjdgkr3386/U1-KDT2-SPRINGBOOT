package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityContrller {
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied"; // src/main/resoureces/templates/accessDenied.html
	}
}
