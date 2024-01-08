package com.fisa.gym.model.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name="membership")
@Entity
public class Membership {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "memberId", referencedColumnName = "id", nullable = false)
	private Member member;
	
	private LocalDate startDate; // 시작 일시
	
	private int month; // 등록 개월 수
	
	private LocalDate recentVisit; // 최근 방문 일시
}