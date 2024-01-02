package com.fisa.gym.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Cart;
import com.fisa.gym.model.domain.Dept;
import com.fisa.gym.model.domain.Member;
import com.fisa.gym.model.dto.CartDTO;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{

}