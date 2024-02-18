package com.ict.teamProject.challenge_room.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.ict.teamProject.challenge_room.service.CRDto;


@Mapper
public interface CRMapper {

	//전체 조회
	List findAll(Map map);
	
	//자기 챌린지 보기
	CRDto findByBBS(int bno);
		
	//입력/수정/삭제
	int save(Map map);
	int update(int cRno);
	int delete(int cRno);
	
	// 자기 방 번호 가져오기
	Integer getMyRoom(String id);
	

}
