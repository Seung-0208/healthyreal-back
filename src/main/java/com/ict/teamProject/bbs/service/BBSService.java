package com.ict.teamProject.bbs.service;

import java.util.List;
import java.util.Map;

import com.ict.teamProject.files.service.FilesDto;

import jakarta.servlet.http.HttpServletRequest;


public interface BBSService<T> {

	//전체보기용
	List<BBSDto> selectAll(Map map);
	
	//상세보기용
	T selectOne(Map map);
	
	//입력/수정/삭제용
	int insert(Map map);
	int update(BBSDto record, FilesDto files);
	int delete(BBSDto record, FilesDto files);
}
