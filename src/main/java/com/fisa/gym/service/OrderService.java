package com.fisa.gym.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fisa.gym.model.CartRepository;
import com.fisa.gym.model.DrinkRepository;
import com.fisa.gym.model.OrderRepository;
import com.fisa.gym.model.domain.Drink;
import com.fisa.gym.model.domain.Order;
import com.fisa.gym.model.dto.OrderDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final DrinkRepository drinkRepository;

	private ModelMapper mapper = new ModelMapper();
    private final DecimalFormat df = new DecimalFormat("###,###");

    public String insert(OrderDTO orderDTO) {
        try {
        	Order order = mapper.map(orderDTO, Order.class);
        	orderRepository.save(order);
        	
            List<Long> drinkId = cartRepository.findDrinkNameByMemberId(2L);
            
            StringBuilder sb = new StringBuilder();
            Map<String, Integer> map = new HashMap<>();
            Map<String, Integer> totalPriceMap = new HashMap<>();
            int sum = 0;
            
            sb.append("+--------------------------+----------+-------------+\n");
            sb.append("|        Drink Name        | Quantity | Total Price |\n");
            sb.append("+--------------------------+----------+-------------+\n");


            for(Long item : drinkId) {
            	Optional<Drink> drink = drinkRepository.findById(item);
            	String name = drink.get().getName();
            	
                map.put(name, map.getOrDefault(name, 0) + 1);
                totalPriceMap.put(name, totalPriceMap.getOrDefault(name, 0) + drink.get().getPrice());
            }
            
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String name = entry.getKey();
                int quantity = entry.getValue();
                int totalPrice = totalPriceMap.get(name);
                
                String formatPrice = df.format(totalPrice);
                sum += totalPrice;
                
                sb.append(String.format("| %-25s | %-8d | %-12s |\n", name, quantity, formatPrice));
            }
            
            String formatSumPrice = df.format(sum);
            sb.append("+-------+--------------+------------+----+-----------+\n");
            sb.append(formatSumPrice).append("원입니다.\n");

//            String formatSumPrice = df.format(sum);

            sb.append("주문 완료");
            
            // 이제 주문 테이블에 해당 목록 넣는 로직 만들기 

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
//            return false;
            return null;
        }
    }
}
