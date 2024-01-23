package com.fisa.gym.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Drink;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Long>{

}