package com.learn.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.domain.User;
import com.learn.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 콘솔 출력 대용 에러 워닝 
@Controller //page 이름으로 반환 (기본 HTML)
//@RestController //json으로 반환 (리엑트) strign 값이 넘어간다.
public class UserController {

	
	private final UserService userService;
	
	
	UserController(UserService userService){
		this.userService = userService; //생성자 주입방식
		
	}
	
	@GetMapping("/users")
	public String getUsers(Model model) {  //페이지이름이다 model에 값 담아서 보낼것 
		String result = "user-list";
		log.info("컨트롤러 users호출");
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return result;
	
	}
	
	@GetMapping("/user")
	@ResponseBody  //값으로만 가는애들 
	public List<User> getUser() {  //페이지이름이다 model에 값 담아서 보낼것 
		log.info("컨트롤러 User GET 호출");
		List<User> result = userService.getAllUsers();
		
		return result;
	
	}
	
}
