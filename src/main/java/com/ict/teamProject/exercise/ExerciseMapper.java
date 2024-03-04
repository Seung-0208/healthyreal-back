package com.ict.teamProject.exercise;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ict.teamProject.exercise.bbs.RoadPathDto;
import com.ict.teamProject.exercise.bbs.RoadPointDto;

@Mapper
public interface ExerciseMapper {
	//경로 등록 세트---------
	public void uploadPath(RoadPathDto dto); //경로 등록
	public void uploadPathPoint(List dto); //경로 포인트 등록
	//경로 등록 세트 end-----
}
