package com.fisa.gym.model.domain;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="payment")
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long paymentId;
	@Column(name = "payment_time")
	private LocalDate paymentTime;
	
	@ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "memberId", nullable = false)
	private Member member;
	
	@Override
	public String toString() {
		return "Payment [PaymentId=" + paymentId + ", paymentTime=" + paymentTime + "]";
	}
	
}

