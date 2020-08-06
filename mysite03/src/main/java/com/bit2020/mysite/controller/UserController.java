package com.bit2020.mysite.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2020.mysite.security.Auth;
import com.bit2020.mysite.security.AuthUser;
import com.bit2020.mysite.service.UserService;
import com.bit2020.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value="/emailcheck")
	public Object emailcheck(String email) {
		System.out.println(email);
		Map<String, Object> map = new HashMap<>();
		map.put("result", "OK");
		
		return map;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping(value="/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@Auth
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@AuthUser UserVo authUser, Model model) {
		
		Long no = authUser.getNo();
		
		UserVo userVo = userService.getUser(no);
		model.addAttribute("userVo", userVo);
		
		return "user/update";
	}

	@Auth
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@AuthUser UserVo authUser, UserVo vo) {
		vo.setNo(authUser.getNo());
		
		userService.updateUser(vo);
		return "redirect:/user/update";
	}
	
//	@ExceptionHandler(Exception.class)
//	public String handlerException() {
//		System.out.println("logging");   // 1.로깅
//		return "error/exception";        // 2.사과 페이지
//	}
}