package com.example.demo.cotroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.CommentInput;
import com.example.demo.service.CommentService;
import com.example.demo.user.User;

@Controller
public class CommentController {
	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@PostMapping("/comments")
	public String writeComment(
			@Validated @ModelAttribute CommentInput commentInput,
			@AuthenticationPrincipal User user,
			BindingResult bindingResult ) {
		System.out.println("commentInput: "+commentInput);
		System.out.println("user: "+user);
		
		if(bindingResult.hasErrors())
			return "redirect:/view/" + commentInput.getArticleId();//localhost:8080/view/3
		
		commentService.writeComment(commentInput.getArticleId(), user.getId(), 
				                   user.getUsername(), commentInput.getContent());
		return "redirect:/view/" + commentInput.getArticleId();  //localhost:8080/view/3
	}
	
	
	
	
	

}
