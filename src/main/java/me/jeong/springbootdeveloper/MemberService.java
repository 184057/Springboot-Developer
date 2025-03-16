package me.jeong.springbootdeveloper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository
            ;
    public void test() {
        // 1. 생성(Create)
        memberRepository.save(new member(1L, "A"));

        // 2. 조회(Read)
        Optional<Member> member = memberRepository.findById(1L);

        // 3. 삭제(Delete)
        memberRepository.deleteById(1L);

    }
}
