package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class TestController { // (리액트, 스프링 연동 테스트)
    @PostMapping("/ip")
    public ResponseEntity<String> ip (HttpServletRequest request){
        System.out.println(request.getRemoteAddr());
        return ResponseEntity.ok(request.getRemoteAddr()); // 클라이언트 ip 주소 반환
    }
}
