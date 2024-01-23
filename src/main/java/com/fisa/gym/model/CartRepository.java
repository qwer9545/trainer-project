package com.fisa.gym.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> { 
	
    @Query("select c.drink.id from Cart c where c.member.id = ?1")
    List<Long> findDrinkNameByMemberId(Long memberId);

}