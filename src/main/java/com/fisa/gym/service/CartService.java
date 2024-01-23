package com.fisa.gym.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fisa.gym.model.CartRepository;
import com.fisa.gym.model.domain.Cart;
import com.fisa.gym.model.dto.CartDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor // TODO 20 line의 repo가 만들어짐. 흐름 파악.
public class CartService {
	
	// TODO new line 반영
	// TODO DI 개념, Spring Bean
    private final CartRepository cartRepository;
	
	// TODO new 생성자 -> Bean이 아님
    private ModelMapper mapper = new ModelMapper();

    public boolean insert(CartDTO cartDTO) {
    	// TODO 에러가 발생해도 클라이언트가 모르는 코드 -> throw e로 던져주기.
        try {
        	cartRepository.save(mapper.map(cartDTO, Cart.class));
        	
//        	Cart cart = mapper.map(cartDTO, Cart.class);
//        	cartRepository.save(cart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
