package com.fisa.gym.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}