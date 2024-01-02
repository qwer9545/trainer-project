package com.fisa.gym.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

}