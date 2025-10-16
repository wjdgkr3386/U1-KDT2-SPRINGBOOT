package com.example.demo.cotroller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Article;
import com.example.demo.domain.ArticleInput;
import com.example.demo.domain.ArticleTag;
import com.example.demo.domain.CommentInput;
import com.example.demo.service.ArticleService;
import com.example.demo.user.User;

@Controller
public class ArticleController {
   private final ArticleService articleService;

	public ArticleController(ArticleService articleService) {
	  this.articleService = articleService;
    }

	@GetMapping("/write")
	public String writePage(Model model) {
		model.addAttribute("articleInput", new ArticleInput());
		return "write"; // "src/main/resources/templates" + "write" + ".html" 
	}
	
	@PostMapping("/write")
	public String submitForm(@Validated @ModelAttribute ArticleInput articleInput,
			                 BindingResult bindingResult,
			                 @AuthenticationPrincipal User user) {
		if(bindingResult.hasErrors()) {
			return "write"; //foward; -> write.html
		}
		
		System.out.printf("Article submitted: %s %s %s %n",
				articleInput.getSubject(), articleInput.getAuthor(), articleInput.getContents());
		articleService.writeArticle(articleInput.getSubject(),  
				                    articleInput.getContents(), 			                
				                    user.getUsername(),
				                    user.getId());
		return "redirect:/";
	}
	
	 @GetMapping("/") // localhost:8080/
	 public String list(Model model) {
	        List<Article> articles = articleService.getAllArticles();
	        model.addAttribute("articles", articles);
	        return "list"; // prefix-"src/main/resources/", "list", suffix-".html"-> src/main/resources/list.html
	   }
	 
	 @GetMapping("/view/{id}") // localhost:8080/view/{5}
	 public String list(@PathVariable("id") Long id, Model model) {
	        Article article = articleService.getArticleById(id);
	        model.addAttribute("article", article);
	        
	        model.addAttribute("commentInput", new CommentInput());
	        return "view"; // prefix-"src/main/resources/", "view", suffix-".html"-> src/main/resources/view.html
	   } 
	 
	 @PreAuthorize("@articleService.getArticleById(#id).isAuthor(#user.getId())") // SpEL 표현식으로 작성한 권한 조사. @은 Bean 참조, #은 메소드 파라미터 참조
	 @GetMapping("/edit/{id}")
	 public String editPage(@PathVariable Long id, Model model, @AuthenticationPrincipal User user) {
		 Article article = articleService.getArticleById(id);
		 System.out.println(article);
		 model.addAttribute("article", article);
		 return "edit"; // src/main/resoureces/templates/edit.html
	 }
	 
	 @PostMapping("edit/{id}")
	 public String editArticle(@PathVariable("id") Long id, 
			                   @Validated ArticleInput articleInput, 
			                   BindingResult bindResult, 
			                   @AuthenticationPrincipal User user) throws AccessDeniedException {
	 try {
		  if(bindResult.hasErrors()) {
			  System.err.println("에러발생");
			  System.out.println(bindResult.getAllErrors());
			  return "edit"; //src/main/resoureces/templates/edit.html로 되돌림.
		  }
		  articleService.updateArticle(id,articleInput.getSubject(), articleInput.getContents(), user.getId());
		  return "redirect:/view/"+id; // localhost:8080/view/3
	 }catch(Exception e) {
		 throw new AccessDeniedException("글을 수정할 권한이 없습니다.");
	 }
	}
	 
	 @PostMapping("/delete/{id}")
	 public String delteArticle(@PathVariable("id") Long id, @AuthenticationPrincipal User user) 
			              throws AccessDeniedException {
		 try {
			articleService.deleteArticle(id, user.getId());//글번호, 회원번호
			return "redirect:/";
		} catch (IllegalStateException e) {
			throw new AccessDeniedException("글을 삭제할 권한이 없습니다.");
		}	 
	 }
	 
	 @GetMapping("/articles/{id}")
	   public String getArticle(@PathVariable("id") Long id, Model model) {
	        ArticleTag articleTag = articleService.getArticleWithTagById(id);
	        System.out.println("articleTag: "+ articleTag);
	        model.addAttribute("articleTag", articleTag);
	        return "article"; // src/main/resources/tempates/article.html
	   }
	 
	 
	 
	 
}
