package com.fisa.gym.model.dto;

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
public class MemberDTO {
	
	private Long id;
	private String memberName;
	private String information;
	
//	public Member toEntity() {
//		return Member.builder().id(id).name(name).build();
//	}
}
