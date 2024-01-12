package com.fisa.gym.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fisa.gym.model.DrinkRepository;
import com.fisa.gym.model.domain.Drink;
import com.fisa.gym.model.dto.DrinkDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DrinkService {
    private final DrinkRepository drinkRepository;
	private ModelMapper mapper = new ModelMapper();
	
	public List<DrinkDTO> getAllDrink() throws Exception {
		List<Drink> drinkAll = drinkRepository.findAll();
		
		List<DrinkDTO> drinkDTOAll = Arrays.asList(mapper.map(drinkAll, DrinkDTO[].class));
		return drinkDTOAll;
	}
	
}
