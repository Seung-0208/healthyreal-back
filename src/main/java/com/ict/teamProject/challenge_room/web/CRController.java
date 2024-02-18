package com.ict.teamProject.challenge_room.web;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ict.teamProject.challenge_room.service.CRDto;
import com.ict.teamProject.challenge_room.service.CRService;
import com.ict.teamProject.chat.service.ChatDto;



@Controller
@RequestMapping("/croom")
@RestController
@CrossOrigin(origins = "http://localhost:3333")
public class CRController {
	
	//서비스 주입
	@Autowired
	private CRService<CRDto> service;
	
	//입력처리]
	@PostMapping("/myRoomNum.do")
	@ResponseBody
	public int myRoomNum(@RequestBody String id) {
		int room;
		System.out.println("id:"+id);
		room = service.selectMyRoom(id);
		return room;
	}/////
	

}
