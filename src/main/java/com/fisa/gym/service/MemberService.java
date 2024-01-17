package com.fisa.gym.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisa.gym.model.MemberRepository;
import com.fisa.gym.model.domain.LoginRequest;
import com.fisa.gym.model.domain.Member;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    public boolean login(String loginId,String password) {
        Optional<Member> optionalMember = memberRepository.findByMemberLoginId(loginId);
        // loginId와 일치하는 User가 없으면 null return
        if(optionalMember.isEmpty()) {
            return false;
        }
        System.out.println("idpass");
        Member member = optionalMember.get();
        
        // 찾아온 User의 password와 입력된 password가 다르면 null return
        if(!member.getMemberLoginPassword().equals(password)) {
            return false;
        }
        System.out.println("pwpass");
        return true;
    }
    
}
