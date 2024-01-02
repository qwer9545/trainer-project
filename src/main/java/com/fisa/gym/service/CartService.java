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
//    private final MemberRepository memberRepository;
//    private final DrinkRepository drinkRepository;
    private ModelMapper mapper = new ModelMapper();
    
    public boolean insert(CartDTO cartDTO) {
    	System.out.println("아 ..............");
        try {
//        	Member member = memberRepository.findById(cartDTO.getMemberId()).orElse(null);
//        	Drink drink = drinkRepository.findById(cartDTO.getDrinkId()).orElse(null);
        	
//        	Cart cart = new Cart();
//        	cart.setMemberId(cartDTO.getMemberId());
//        	cart.setDrinkId(cartDTO.getDrinkId());
        	Cart cart = mapper.map(cartDTO, Cart.class);
        	cartRepository.save(cart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean update(int cartno, String newLoc) {
//        try {
//        	Cart cart = cartRepository.findById(cartno).orElse(null);
//            if (cart != null) {
//            	cart.setLoc(newLoc);
//                cartRepository.save(cartno);
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

//    public List<Cart> selectAll() {
//        return cartRepository.findAll();
//    }
    
    // 부가적인 메소드는 필요에 따라 추가할 수 있습니다.
}
