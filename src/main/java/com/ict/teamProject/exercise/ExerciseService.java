package com.ict.teamProject.exercise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ict.teamProject.exercise.bbs.RoadPathDto;
import com.ict.teamProject.exercise.bbs.RoadPointDto;

@Service
public class ExerciseService {
	ExerciseMapper mapper;
	public ExerciseService(ExerciseMapper mapper) {
		this.mapper = mapper;
	}
	
	public void uploadPath(RoadPathDto dto) {
		mapper.uploadPath(dto);
	}
	
	public void uploadPathPoint(List dto) {
		mapper.uploadPathPoint(dto);
	}
}
