package com.fisa.gym.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fisa.gym.model.MemberRepository;
import com.fisa.gym.model.OrderRepository;
import com.fisa.gym.model.domain.Member;
import com.fisa.gym.model.domain.Order;
import com.fisa.gym.model.dto.OrderDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

	private ModelMapper mapper = new ModelMapper();

    public boolean insert(OrderDTO orderDTO) {
        try {
        	System.out.println("order 테스트************");
        	Optional<Member> member = memberRepository.findById(orderDTO.getMemberId());
        	System.out.println(member);

        	
        	Order order = mapper.map(orderDTO, Order.class);
        	
        	System.out.println(orderDTO);
            

            // Order와 Member의 양방향 관계 설정
//            order.setMember(member);
//            member.getOrders().add(order);

            // carts에는 빈 리스트 설정
            order.setCarts(new ArrayList<>());

            
            
    		System.out.println(order);

        	orderRepository.save(order);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
