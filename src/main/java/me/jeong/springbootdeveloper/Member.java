package me.jeong.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 1. 엔티티로 지정 (Member객체를 JPA가 관리하는 엔티티로 지정, 즉 Member 클래스와 실제 데이터베이스의 테이블을 매핑시킨다.)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 2. 기본 생성자 (엔티티는 반드시 기본 생성자가 있어야하고, 접근 제어자는 public 또는 protected이어야 하는데 protected가 더 안전하므로 protected로 생성)
@AllArgsConstructor

public class Member {
    @Id // 3. id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false) // 5. name이라는 not null 컬럼과 매핑
    private String name;
}


//4. 자동키 생성 설정 방식
//AUTO : 선택한 데이터베이스 방언(dialect)에 따라 방식을 자동으로 선택(기본 값)
//IDENTITY : 기본 키 생성을 데이터베이스에 위임(= AUTO_INCREMENT)
//SEQUNCE : 데이터베이스 시퀀스를 사용해서 기본 키를 할당하는 방법. 오라클에서 주로 사용함
//TABLE : 키 생성 테이블 사용

//@Column 에너테이션의 속성
//name : 필드와 매핑할 컬럼 이름. 설정하지 않으면 필드 이름으로 지정해줌
//nullable : 컬럼의 null 허용 여부
//unique : 컬럼의 유일한 값(unique) 여부. 설정하지 않으면 false(non.unique)
//columnDefinition : 컬럼 정보 설정. default값을 줄 수 있음