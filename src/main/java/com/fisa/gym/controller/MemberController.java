package com.fisa.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fisa.gym.model.domain.LoginRequest;
import com.fisa.gym.service.MemberService;

@Controller
@SessionAttributes({"loginId","password"})
public class MemberController {
	
	@Autowired
	MemberService service;
	
//	@RequestMapping(path = "/memberlogin", method = RequestMethod.POST)
//	public String member(String loginId, String password ,HttpSession session, Model model) throws Exception {
//		if(service.login(loginId,password)) {
//			
//			session.setAttribute("memberLoginId",loginId);
//			session.setAttribute("memberLoginPassword",password);
//			String memberLoginId = (String) session.getAttribute("memberLoginId");
//			model.addAttribute("memberLoginId",memberLoginId);
//			
//			return "redirect:/";
//		}
//		return "redirect:/";
//	
//	}
//	원래코드
	
	@RequestMapping(value = "/memberlogin", method = RequestMethod.POST)
    public String login(Model model, String loginId, String password){
    	model.addAttribute("loginId", loginId);
    	model.addAttribute("password", password);
    	System.out.println(model.toString());
        return "redirect:/";
    }
  // 우선 세션 모델로 잘받아지는지 프린트만해봄

	@ExceptionHandler
	public String handler(Exception e) {
		e.printStackTrace();
		return null;
	}
}


