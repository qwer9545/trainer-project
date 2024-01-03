package com.fisa.gym.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{
	Optional <Member> findByMemberLoginId(String loginId);
//	boolean existsByMemberLoginId(String id);
}