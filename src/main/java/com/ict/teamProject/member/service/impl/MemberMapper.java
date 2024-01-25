package com.ict.teamProject.member.service.impl;

import org.apache.ibatis.annotations.Mapper;

import com.ict.teamProject.member.service.MemberDto;

@Mapper
public interface MemberMapper {
	
	int saveMember(MemberDto dto);
	
	 boolean checkPhoneNumber(String tel);

}
