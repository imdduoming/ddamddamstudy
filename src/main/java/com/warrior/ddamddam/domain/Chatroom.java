package com.warrior.ddamddam.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Chatroom extends Timestamped{
    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long roomId;

    @Column // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String name;

//    @JoinColumn(name = "USER_ID" )
//    @ManyToOne
//    private User user; //룸 개설자

}
