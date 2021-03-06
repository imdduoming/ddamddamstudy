package com.warrior.ddamddam.user.controller;

import com.warrior.ddamddam.user.dto.SignupRequestDto;
import com.warrior.ddamddam.user.model.User;
import com.warrior.ddamddam.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @Autowired
//    public UserController(UserService userService) {
//
//        this.userService = userService;
//    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {

        return "login";
    }

    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    // 아이디 중복 검사
    @PostMapping("/user/userIdChk")
    @ResponseBody
    public String userIdChk(@RequestBody String id) {
        boolean result = userService.userIdChk(id);

        if(result==false) {
            return "fail";	// 중복 아이디가 존재

        } else {
            return "success";	// 중복 아이디 x
        }
    }

    // 로그아웃
    @GetMapping("/user/logout")
    public String logout(HttpSession session) throws Exception{
        session.invalidate();
        return "/";
    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(String code) {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        userService.kakaoLogin(code);
        return "redirect:/";
    }

    @GetMapping("/user/naver/callback")
    public String naverLogin(String code) {
        // authorizedCode: 네이버 서버로부터 받은 인가 코드
        userService.naverLogin(code);
        return "redirect:/";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {

        return "signup.html";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }

    // 일반 user 접근불가 페이지
    @GetMapping("/user/forbidden")
    public String forbidden() {
        return "forbidden";
    }

//    @GetMapping("/mypage")
//    public String mypage(){
//        return username;
//    }
}