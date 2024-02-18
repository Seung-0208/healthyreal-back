package com.ict.teamProject.challenge_room.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.ict.teamProject.bbs.service.BBSDto;
import com.ict.teamProject.bbs.service.BBSService;
import com.ict.teamProject.bbs.service.LikesDto;
import com.ict.teamProject.challenge_room.service.CRDto;
import com.ict.teamProject.challenge_room.service.CRService;
import com.ict.teamProject.files.service.FilesDto;



@Service
public class CRServiceImpl implements CRService<CRDto> {

	//매퍼 인터페이스 주입
	@Autowired
	private CRMapper mapper;

	@Override
	public List<CRDto> selectAll(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CRDto viewMyRoom(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectMyRoom(String id) {
		Integer room = mapper.getMyRoom(id);
		return room;
	}

	@Override
	public int insert(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CRDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	


}
