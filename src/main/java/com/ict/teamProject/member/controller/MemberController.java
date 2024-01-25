package com.ict.teamProject.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ict.teamProject.member.service.MemberDto;
import com.ict.teamProject.member.service.MemberService;

@RestController
public class MemberController {

	private MemberService service;
	
	public MemberController(MemberService service) {
		this.service=service;
		System.out.println("MemberController 생성자");
	}
	
	@CrossOrigin(origins = "http://localhost:3333/")
	@PostMapping("/register")
	public ResponseEntity<MemberDto> join(@RequestBody MemberDto dto){
		int affected=service.join(dto);
		System.out.println("affected="+affected);
		return ResponseEntity.ok().header("Content-Type", "application/json").body(dto);
	}
}
