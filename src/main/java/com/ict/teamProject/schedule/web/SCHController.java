package com.ict.teamProject.schedule.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ict.teamProject.schedule.service.SCHDto;
import com.ict.teamProject.schedule.service.SCHService;



@Controller
@RequestMapping("/sch")
@RestController
@CrossOrigin(origins = "http://localhost:3333")
public class SCHController {
	
	//서비스 주입
	@Autowired
	private SCHService<SCHDto> service;
	
	//좋아요 얻어오기
	@PostMapping("/insert.do")
	public void insert(@RequestBody Map map) {
		
	}
}
