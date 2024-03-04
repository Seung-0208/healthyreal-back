package com.ict.teamProject.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.teamProject.exercise.bbs.RoadPathDto;
import com.ict.teamProject.exercise.bbs.RoadPointDto;

@RequestMapping("/exercise")
@RestController
@CrossOrigin(origins = "http://localhost:3333")
public class ExerciseController {
	ExerciseService service;
	public ExerciseController(ExerciseService service) {
		this.service = service;
	}
	
	@PostMapping("/upload")
	public void uploadPath(@RequestBody Map pathInfo) {
		//{id=sy0208, time=2, roadPoint=[{La=127.02852969697523, Ma=37.49260268269215}, {La=127.02999424488542, Ma=37.49305732857341}], roadPointName=[서초동 1419, 역삼동 858]}
		System.out.println("경로 파라미터:"+pathInfo);
		List roadPoints = new ArrayList();
		RoadPathDto roadPathDto = new RoadPathDto().builder()
									.id(String.valueOf(pathInfo.get("id")))
									.rpath_time(pathInfo.get("time"))
									.build();
		roadPoints.add(roadPathDto); //첫번째 원소에는 경로의 아이디 값 저장
		
		List pathPoints = (ArrayList)pathInfo.get("roadPoint");
		List pathPointsName = (ArrayList)pathInfo.get("roadPointName");
		for(int i=0; i<pathPoints.size(); i++) {
			RoadPointDto dto = new RoadPointDto().builder()
									.lat(((Map)pathPoints.get(i)).get("La"))
									.lng(((Map)pathPoints.get(i)).get("Ma"))
									.order_num(i)
									.pointname(String.valueOf(pathPointsName.get(i)))
									.build();
			roadPoints.add(dto);
		}
		service.uploadPathPoint(roadPoints);
	}
}
