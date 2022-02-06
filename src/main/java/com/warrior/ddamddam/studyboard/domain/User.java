package com.warrior.ddamddam.studyboard.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=30)
    private String username;

    @Column(nullable=false,length=100)
    private String password;

    @Column(nullable=false, length=50)
    private String email;

    @Column(nullable = false, length=10)
    private String nickname;

}
