package me.jeong.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository;

    pubilc List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
