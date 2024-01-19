package com.ict.teamProject.bbs.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ict.teamProject.bbs.service.BBSDto;

@Mapper
public interface BBSMapper {

	//전체 조회
	List findAll(Map map);
	
	//레코드 하나
	BBSDto findByBBS(Map map);
	
	//키로 조회해서 레코드 하나 삭제
	int deleteByKey(BBSDto record);
	
	//키로 조회해서 레코드 하나 수정
	int updateByKey(BBSDto record);
	
	//입력
	int save(Map map);
	
	//전체 레코드 수 조회	
	int count(Map map);
	
	int saveUser(Map<String, String> map);
	
}
