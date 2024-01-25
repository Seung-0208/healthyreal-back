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
	
	
}
