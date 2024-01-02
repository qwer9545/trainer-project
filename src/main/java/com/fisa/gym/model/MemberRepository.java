<<<<<<< HEAD
package com.fisa.gym.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Cart;
import com.fisa.gym.model.domain.Dept;
import com.fisa.gym.model.domain.Member;
import com.fisa.gym.model.dto.CartDTO;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{

=======
package com.fisa.gym.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{
	Optional <Member> findByMemberLoginId(String loginId);
//	boolean existsByMemberLoginId(String id);
>>>>>>> ec743a005378212656caae18175b578e71616a55
}