package com.ict.teamProject.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ict.teamProject.member.service.MemberDto;
import com.ict.teamProject.member.service.MemberService;

import oracle.jdbc.OracleDatabaseException;

import org.springframework.ui.Model;


@CrossOrigin(origins = "http://localhost:3333")
@RestController
public class MemberController {

	private MemberService service;
	
//	
//	@Transactional
//	@CrossOrigin(origins = "http://localhost:3333")
//	@RequestMapping(value = "/user/updateSocialUser",  method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
//	public int updateSocialUser(@RequestBody MemberDto dto){
//	    int affected = service.updateSocialUser(dto);
//	    
//	    System.out.println("하? 여기 들어와 지니?"+dto);
//	    return affected;
//	}
	
	public MemberController(MemberService service) {
		this.service=service;
		System.out.println("MemberController 생성자");
	}
	
	@RequestMapping(value = "/user/View", method = {RequestMethod.GET,RequestMethod.POST})
	public MemberDto view(@RequestParam String id){
		MemberDto memberdata = service.selectdata(id);
		return memberdata;
	}
	@RequestMapping(value = "/user/Edit", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
	public int edit(@RequestParam String id, String colname, String newcolval){
		int affected = service.updatedata(id, colname, newcolval);
		
		System.out.println("여기 들어와 지니?");
		return affected;
	}
	
	
	@RequestMapping(value = "/usercheck", method = {RequestMethod.GET,RequestMethod.POST,})
	public int usercheck(@RequestParam String id, String pwd) {
		System.out.println("chk");
		return service.logincheck(id, pwd);
	}
	
	
	@RequestMapping(value = "/searchPoint", method = {RequestMethod.GET})
	public Map searchPoint(@RequestParam String id) {
		System.out.println("searchPoint");
		return service.searchPoint(id);
	}
	
	//FMC 토큰을 DB에 저장
	@PostMapping("/fmctoken")
	public void saveFMCToken(@RequestBody Map map) {
		service.saveFMCToken(map);
	}
	
	//DB에 저장된 FMC 토큰 불러오기
	@GetMapping("/get/fmctoken")
	public String findFMCToken(@RequestParam String id) {
		return service.findFMCTokenById(id);
	}
	@CrossOrigin(origins = "http://localhost:3333")
	@RequestMapping(value = "/getUserAddress", method = {RequestMethod.GET,RequestMethod.POST,})
	public Map getUserAddress(@RequestParam String id) {
		System.out.println("찾을 유저:"+id);
		return service.getUserAddress(id);
	}
}
