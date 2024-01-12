package com.fisa.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisa.gym.model.dto.DrinkDTO;
import com.fisa.gym.service.DrinkService;

@RestController
public class DrinkController {
	@Autowired
	DrinkService drinkService;

	@GetMapping("/drinkMenu")
    protected ResponseEntity<List<DrinkDTO>> getDrinkList() {
        try {
            List<DrinkDTO> result = drinkService.getAllDrink();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}