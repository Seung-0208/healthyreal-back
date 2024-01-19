package com.ict.teamProject.bbs.service;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;


public interface BBSService<T> {

	//상세보기용
	T selectOne(Map map);
	
	//입력/수정/삭제용
	int insert(Map map);
	int update(T record);
	int delete(T record);
}
