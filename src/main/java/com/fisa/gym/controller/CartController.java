package com.fisa.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisa.gym.model.dto.CartDTO;
import com.fisa.gym.service.CartService;

@RestController
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/cartInsert")
	protected String cartInsert(CartDTO cartDTO) throws Exception {
		boolean result = cartService.insert(cartDTO);
		System.out.println("**************************컨트롤러 들어왔냐고.......");
		return result ? "카트에 상품 추가 완료" : "추가 실패";
	}
}
