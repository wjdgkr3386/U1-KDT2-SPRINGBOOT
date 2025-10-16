package com.example.demo.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("register")
	public String registerPage(Model model) {
		model.addAttribute("userInput", new UserInput());
		return "user/register"; //-> src/main/resources/templates/user/register.html
	}
	
	
	@PostMapping("register")
	public String register(@ModelAttribute UserInput userInput, Model model) {
		System.out.println("username:"+userInput.getUsername()+", password:"+userInput.getPassword());
		userService.joinUser(userInput.getUsername(), userInput.getPassword());
		return "redirect:/login"; //-> localhost:8080/login 
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login"; // "src/main/resources/templates"+"user/login"+".html"
	}
	

}
