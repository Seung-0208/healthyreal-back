package com.ict.teamProject.member.service;

import org.springframework.stereotype.Service;

import com.ict.teamProject.member.service.impl.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;

	
	public MemberService(MemberMapper mapper) {
		this.mapper=mapper;
	}
	
	public int join(MemberDto dto) {
		return mapper.saveMember(dto);
	}
	
	
	public MemberDto selectdata(String id) {
		return mapper.findByMember(id); //MemberMapper 인터페ㅔ이스의 findByMember메소드 호출
	}
	
}
