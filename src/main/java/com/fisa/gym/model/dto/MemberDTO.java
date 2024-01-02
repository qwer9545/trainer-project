package com.fisa.gym.model.dto;

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
	
	private Long memberId;
	private String memberLoginId;
	private String memberLoginPassword;
	private String memberName;
	
//	public Member toEntity() {
//		return Member.builder().id(id).name(name).build();
//	}
}

