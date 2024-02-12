package com.ict.teamProject.selftest;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ict.teamProject.selftest.dto.AllergyInfoDto;
import com.ict.teamProject.selftest.dto.HateFoodInfoDto;
import com.ict.teamProject.selftest.dto.MemberAllergyDto;

@Mapper
public interface SelftestMapper {
	public List<AllergyInfoDto> findAllAllergy();
	public List<HateFoodInfoDto> findAllHateFood();
	public int saveMemberAllergy(String id, int allergy_no);
}
