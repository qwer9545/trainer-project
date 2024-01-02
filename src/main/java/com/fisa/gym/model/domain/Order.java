package com.fisa.gym.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="order")
@Entity
public class Order {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	@ManyToOne
	@JoinColumn(name="memberId", referencedColumnName="memberId")
	private Member member;
	
	@OneToMany
	@JoinColumn(name="drinkId", referencedColumnName="drinkId")
	private Drink drink;
}