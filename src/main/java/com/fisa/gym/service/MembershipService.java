package com.fisa.gym.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisa.gym.model.MembershipRepository;
import com.fisa.gym.model.domain.Membership;

@Service
public class MembershipService {

	@Autowired
	private MembershipRepository membershipRepository;

	private ModelMapper mapper = new ModelMapper();

	public List<Membership> getAllMembership() throws SQLException {

		List<Membership> membershipAll = membershipRepository.findAll();

		if (membershipAll == null) {
			return null;
		}

		List<Membership> MembershipAll = Arrays.asList(mapper.map(membershipAll, Membership[].class));

		return MembershipAll;
	}

	public Long getDateDiff(long i) throws SQLException {

		Long result = membershipRepository.findDateDayById(i);

		return result;
	}

}