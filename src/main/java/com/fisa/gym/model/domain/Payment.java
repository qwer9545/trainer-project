package com.fisa.gym.model.domain;

import java.security.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Table(name="member_table")

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id")
	private Long paymentId;
	@Column(name = "payment_time")
	private DateTimeFormat paymentTime;
	
	@OneToMany(mappedBy = "memberId")
//	@OneToOne
//    @JoinColumn(name = "memberId", referencedColumnName = "memberId", nullable = false)
//	@JoinColumn(name = "membership_no")
//	@JoinColumn(name = "ex)Order ") //수정필요
//	private orderId
	@Override
	public String toString() {
		return "Payment [PaymentId=" + paymentId + ", paymentTime=" + paymentTime + "]";
	}
	
}

