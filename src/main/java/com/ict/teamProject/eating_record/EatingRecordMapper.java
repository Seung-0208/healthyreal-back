package com.ict.teamProject.eating_record;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ict.teamProject.eating_record.dto.EatingRecordDto;

@Mapper
public interface EatingRecordMapper {

	int savediet(String id, String mealtype, String eating_foodname, String eating_recipeCode);
	EatingRecordDto getdailydiet(String id, Date eating_date);
}
