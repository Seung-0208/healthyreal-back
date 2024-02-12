package com.ict.teamProject.selftest;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ict.teamProject.selftest.dto.AllergyInfoDto;
import com.ict.teamProject.selftest.dto.HateFoodInfoDto;

@Service
public class SelftestService {
	
	//mapper 생성자 주입
	private SelftestMapper mapper;
	public SelftestService(SelftestMapper mapper) {
		this.mapper = mapper;
	}
	
	//알러지 Data
	public List<AllergyInfoDto> findAllAllergy() {
		return mapper.findAllAllergy();
	}
	
	public List<HateFoodInfoDto> findAllHateFood() {
		return mapper.findAllHateFood();
	}
	
	public int saveMemberAllergy(String id, int allergy_no) {
		return mapper.saveMemberAllergy(id, allergy_no);
	}
}
