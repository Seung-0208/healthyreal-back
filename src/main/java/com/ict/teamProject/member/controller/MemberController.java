package com.ict.teamProject.member.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.ict.teamProject.member.service.MemberDto;
import com.ict.teamProject.member.service.MemberService;

@RestController
@CrossOrigin(origins = "http://localhost:3333")
public class MemberController {

	private MemberService service;
	
	public MemberController(MemberService service) {
		this.service=service;
		System.out.println("MemberController 생성자");
	}
	
	@PostMapping("/register")
	public ResponseEntity<MemberDto> join(@RequestBody MemberDto dto){
		int affected=service.join(dto);
		System.out.println("affected="+affected);
		return ResponseEntity.ok().header("Content-Type", "application/json").body(dto);
	}
	

	@RequestMapping(value = "/member_info/View.do", method = {RequestMethod.GET,RequestMethod.POST})
	public MemberDto view(@RequestParam String id){
		MemberDto memberdata = service.selectdata(id);
		return memberdata;
	}
}
