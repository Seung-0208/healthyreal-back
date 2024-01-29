package com.ict.teamProject.bbs.service.impl;

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
import com.ict.teamProject.files.service.FilesDto;



@Service("service")
public class BBSServiceImpl implements BBSService<BBSDto> {

	//매퍼 인터페이스 주입
	@Autowired
	private BBSMapper mapper;
	
	
	//게시물 등록
	@Override
	public Map insert(Map map) {
		try {
	        // 시퀀스 값을 먼저 가져오는 쿼리 실행
	        int generatedKey = mapper.getSeqNextVal();
	        map.put("getBno", generatedKey);
			mapper.save(map);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//게시물 파일등록
	@Override
	public int insertFile(Map map) {
		int affected=0;
		try {
			affected=mapper.saveFiles(map);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return affected;		
	}
	
	//게시물 전체 조회
	@Override
	public List<BBSDto> selectAll() {
		List records=mapper.findAll();
		return records;
	}
	
	//게시물에 해당하는 파일 가져오기
	@Override
	public List<BBSDto> selectFiles(int bno) {
		List records=mapper.findFile(bno);
		System.out.println(records);
		return records;
	}

	//게시물 상세보기
	@Override
	public BBSDto selectOne(int bno) {		
		return mapper.findByBBS(bno);
	}
	
	//자기 게시글 보기
	@Override
	public List<BBSDto> selectMy(String id) {
		return mapper.findMyByBBS(id);
	}

	//게시물 수정
	@Override
	public int update(BBSDto dto) {
		int affected=0;
		try {
			affected=mapper.update(dto);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return affected;
	}

	//트랜잭션 처리 관련 빈 주입 받기
	@Autowired
	private TransactionTemplate template;

	
	@Override
	public int deleteBBS(int bno) {	
		int affected=0;
		affected = mapper.deleteBBS(bno);
		return affected;
	}
	
	@Override
	public int deleteFiles(int bno) {
		int affected=0;
		affected = mapper.deleteFiles(bno);
		return affected;	
	}


}
