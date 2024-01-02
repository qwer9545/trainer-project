package com.fisa.gym.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="drink")
@Entity
public class Drink {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long drinkId;
	private String drinkName;
	private int drinkPrice;
}