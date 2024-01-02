package com.fisa.gym.model.domain;

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
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private Long id;
	@Column(name = "member_name")
	private String memberName;
	private String information;
	
	@OneToMany(mappedBy = "memberId")
//	@OneToOne
//    @JoinColumn(name = "memberId", referencedColumnName = "memberId", nullable = false)
//	@JoinColumn(name = "membership_no")
//	@JoinColumn(name = "ex)Order ") //수정필요
//	private orderId
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append(super.toString()); //list도 아니라 concat으로 그냥 써도되나요
		return "Member [id=" + id + ", memberName=" + memberName + ", information=" + information + "]";
	}
	
}

