package com.ict.teamProject.member.service.impl;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ict.teamProject.member.service.MemberDto;

@Mapper
public interface MemberMapper {
	
	int saveMember(MemberDto dto);
	
	 boolean checkPhoneNumber(String tel);



	String findbyUserPassword(Map map);
	Map<String, Object> getInfo(String id);
	int isPreviousUser(String id);
	
	MemberDto findByUsername(String id);
	void joinSocialMember(MemberDto dto);
	MemberDto findByMemberInfo(String id);
	
	//회원가입
	void joinMemberInfo(MemberDto dto);
	void profileImageTable(MemberDto dto);

}
