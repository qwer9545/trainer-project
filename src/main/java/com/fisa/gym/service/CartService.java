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
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
	private ModelMapper mapper = new ModelMapper();

    public boolean insert(CartDTO cartDTO) {
        try {
        	Cart cart = mapper.map(cartDTO, Cart.class);
        	cartRepository.save(cart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
