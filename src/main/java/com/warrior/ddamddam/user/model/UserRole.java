package com.warrior.ddamddam.user.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    USER, // 사용자 권한
    ADMIN // 관리자 권한
}