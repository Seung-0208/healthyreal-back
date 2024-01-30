package com.ict.teamProject.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ict.teamProject.security.util.JWTTokens;
import com.ict.teamProject.member.service.MemberDetailService;
import com.ict.teamProject.member.service.MemberDto;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.RestController
public class MemberDtailController {

	@Autowired
	private MemberDetailService service;
	
	// 로그인 후 user권한으로 쿠키에있는 token전달
	@PostMapping("/user/getToken")
	public String getToken(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if ("User-Token".equals(cookie.getName())) {  // 쿠키의 이름이 "User-Token"인 경우
	                String cookieValue = cookie.getValue();
	                System.out.println("쿠키 값: " + cookieValue);
	                return cookieValue;
	            }
	        }
	    }
	    
	    System.out.println("쿠키를 찾을+ 수 없습니다.");
		return "NoCookie";
	}
	
	// 토큰으로 이름(닉네임),프로필이미지 전달
	@GetMapping("/user/getMemberInfo")
	public MemberDto getMemberInfo(HttpServletRequest request) {
		
		String token = null;
		Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if ("User-Token".equals(cookie.getName())) {  // 쿠키의 이름이 "User-Token"인 경우
	                String cookieValue = cookie.getValue();
	                token = cookieValue;
	            }
	        }
	    }
	    Map username = JWTTokens.getTokenPayloads(token);
	    String id = (String)username.get("username");
	    
		MemberDto info = service.findByMemberInfo(id);
		return info;
	}
	
	@GetMapping("/isSocialLogin")
	public String isSocialLogin(HttpServletRequest request) {
		
		String token = null;
		Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if ("User-Token".equals(cookie.getName())) {  // 쿠키의 이름이 "User-Token"인 경우
	                String cookieValue = cookie.getValue();
	                token = cookieValue;
	            }
	        }
	    }
	    
		return token;
	}
}
