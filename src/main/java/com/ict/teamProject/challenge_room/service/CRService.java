package com.ict.teamProject.challenge_room.service;

import java.util.List;
import java.util.Map;



public interface CRService<T> {

	//전체 챌린지 보기
	List<CRDto> selectAll(Map map);
	
	//자기 챌린지 보기
	CRDto viewMyRoom(String id);
	
	//자기 챌린지 방 번호 찾기
	int selectMyRoom(String id);
		
	//입력/수정/삭제용
	int insert(Map map);
	int update(CRDto dto);
	int delete(Map map);
	
}
