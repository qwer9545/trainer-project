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
public class OrderDTO {
	private Long id;
	private Long memberId;
//	private Long productOrderId;
}
