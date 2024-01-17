package com.fisa.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fisa.gym.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberRestController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(path = "/memberlogin", method = RequestMethod.POST)
	public String member(String loginId, String password ,HttpSession session, Model model) throws Exception {
		if(service.login(loginId,password)) {
			
			session.setAttribute("memberLoginId",loginId);
			session.setAttribute("memberLoginPassword",password);
			String memberLoginId = (String) session.getAttribute("memberLoginId");
//			model.addAttribute("memberLoginId",memberLoginId);
			
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	
	@ExceptionHandler
	public String handler(Exception e) {
		e.printStackTrace();
		return null;
	}
}


