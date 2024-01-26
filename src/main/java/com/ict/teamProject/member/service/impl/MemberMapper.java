package com.ict.teamProject.member.service.impl;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ict.teamProject.member.service.MemberDto;

@Mapper
public interface MemberMapper {
	
	int saveMember(MemberDto dto);
	
	 boolean checkPhoneNumber(String tel);
	 
	 //레코드 하나
	 MemberDto findByMember(String id);
	 
	 int updateMember(String colname, String val);

}
