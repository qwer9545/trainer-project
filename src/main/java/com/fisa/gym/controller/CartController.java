package com.fisa.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisa.gym.model.dto.CartDTO;
import com.fisa.gym.service.CartService;

import jakarta.servlet.http.HttpSession;

@RestController
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/cartInsert")
	protected String cartInsert(CartDTO cartDTO, HttpSession session) throws Exception {
		boolean result = cartService.insert(cartDTO);
		return result ? "카트에 상품 추가 완료" : "추가 실패";
	}
}
