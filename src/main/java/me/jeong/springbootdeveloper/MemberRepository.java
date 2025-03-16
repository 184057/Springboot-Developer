package me.jeong.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}

//리포지토리는 엔티티에 있는 데이터들을 조회하거나 저장, 변경, 삭제를 할때 사용하는 인터페이스로, 스프링 데이터 JPA에서 제공하는 인터페이스인 JpaRepository 클래스를 상속받아 간단하게 구현할 수 있다.
//JpaRepository 클래스를 상속받을 때, 엔티티 Member와 기본키 타입 Long을 인수로 넣어준다.
