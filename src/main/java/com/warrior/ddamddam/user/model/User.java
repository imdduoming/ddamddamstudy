package com.warrior.ddamddam.user.model;

import com.warrior.ddamddam.gongstagram.domain.Timestamped;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 객체 생성 체크
@Entity // DB 테이블
public class User extends Timestamped {

    public User(String username, String password, String email, UserRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String username, String password, String email, UserRole role, Long apiId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.apiId = apiId;
    }

//    public User(String username, String password, String email, UserRole role, Long naverId) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.role = role;
//        this.naverId = naverId;
//    }

    // ID값 (Primary Key) 자동 생성&증가
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotNull
    @Column(length = 10, unique = true)
    private String username;

    @NotNull
    @Column
    private String password;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Column
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Column
    private LocalDateTime signupDate;

    @PrePersist
    public void signupDate() {
        this.signupDate = LocalDateTime.now();
    }

    @Column(nullable = true)
    private Long apiId;

//    @Column(nullable = true)
//    private Long naverId;
}

