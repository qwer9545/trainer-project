package com.fisa.gym.model.dto;

import java.time.LocalDate;

import com.fisa.gym.model.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Builder
public class MembershipDTO {
	
	private Long membershipId;
	private Member member;
	private LocalDate startDate;
	private int month;
	private LocalDate recentVisit;
	
}