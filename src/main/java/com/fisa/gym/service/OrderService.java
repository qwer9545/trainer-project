package com.fisa.gym.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fisa.gym.model.OrderRepository;
import com.fisa.gym.model.domain.Order;
import com.fisa.gym.model.dto.OrderDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

	private ModelMapper mapper = new ModelMapper();
	
    public boolean insert(OrderDTO orderDTO) {
        try {
        	Order order = mapper.map(orderDTO, Order.class);
            order.setCarts(new ArrayList<>());

        	orderRepository.save(order);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
