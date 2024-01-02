package com.fisa.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import com.fisa.gym.model.domain.LoginRequest;
import com.fisa.gym.service.MemberService;

@Controller
public class MemberRestController {
	
	@Autowired
	MemberService service;
	
	@PostMapping("/memberlogin")
	public String member(LoginRequest req) throws Exception {
		System.out.println("restcontroller======================" + req);
//		return service.login(req);
		if(service.login(req))
			return "redirect:/afterlogin.jsp";
		return "redirect:/nologin.jsp";
	}
	
	
	@ExceptionHandler
	public String handler(Exception e) {
		e.printStackTrace();
		return null;
	}
}


