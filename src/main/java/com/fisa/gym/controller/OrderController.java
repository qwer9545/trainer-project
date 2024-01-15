package com.fisa.gym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisa.gym.model.dto.OrderDTO;
import com.fisa.gym.service.OrderService;

import jakarta.servlet.http.HttpSession;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("/order")
	protected String orderInsert(OrderDTO orderDTO, HttpSession session) throws Exception {
		boolean result = orderService.insert(orderDTO);
		return result ? "주문 완료" : "주문 실패";
	}
}