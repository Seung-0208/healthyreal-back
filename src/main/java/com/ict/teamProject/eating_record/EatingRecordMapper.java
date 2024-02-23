package com.ict.teamProject.eating_record;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ict.teamProject.eating_record.dto.EatingRecordDto;

@Mapper
public interface EatingRecordMapper {

	int savediet(String id, String mealtype, String eating_foodname, int eating_recipeCode);
	List<EatingRecordDto> getdailydiet(String id);
	int updatediet(String id, String mealtype, String eating_foodname, int eating_recipeCode);
//	List<Map<String, Object>> getIngredients(int recipeCode);
}
