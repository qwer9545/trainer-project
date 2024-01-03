package com.fisa.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisa.gym.model.domain.Membership;
import com.fisa.gym.service.MembershipService;

@RestController
public class MembershipController {

	@Autowired
	MembershipService membershipService;

	// 모든 ProbonoProject 검색 메소드
	@GetMapping("/membershipAll")
	public List<Membership> membershipAll() throws Exception {
		return membershipService.getAllMembership();
	}

	@GetMapping("/membershipDateDiff")
	public long membershipDateDiff() throws Exception {
		System.out.println("====");
		long v = membershipService.getDateDiff(2);
		System.out.println("------------------- " + v);
		return v;
	}
	
	@ExceptionHandler
	public String hander(Exception e) {
		e.printStackTrace();
		return null;
	}
}