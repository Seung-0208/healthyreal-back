package com.ict.teamProject.selftest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ict.teamProject.selftest.dto.AllergyInfoDto;
import com.ict.teamProject.selftest.dto.HateFoodInfoDto;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;
import java.nio.file.StandardCopyOption;
@RestController

@CrossOrigin(origins = "http://localhost:3333")
public class SelftestController {
	SelftestService service;
	public SelftestController(SelftestService service) {
		this.service = service;
	}
	
	@GetMapping("/Allergy/ListView.do") //조회
	public List<AllergyInfoDto> findAllList(){
		List<AllergyInfoDto> allergyInfolist = service.findAllAllergy();
		System.out.println("아웃풋 : "+allergyInfolist);
		return allergyInfolist;
	}
	
	@GetMapping("/HateFood/ListView.do") //조회
	public List<HateFoodInfoDto> findAllHateFood(){
		List<HateFoodInfoDto> hatefoodInfolist = service.findAllHateFood();
		System.out.println("아웃풋 : "+hatefoodInfolist);
		return hatefoodInfolist;
	}
	
//	@PostMapping("/SaveMember/Allergy")
//	public void saveMemberAllergy(@RequestBody Map map) {	    
//		System.out.println("들어온값:"+map);
//		String id = (String) map.get("id");
//		String allergies = (String) map.get("allergies");
//		String[] allergyArray = allergies.split(",");
//	    for (String allergy : allergyArray) {
//	    	int allergyInt = Integer.parseInt(allergy.trim());
//	        service.saveMemberAllergy(id, allergyInt);
//	    }
//	}
}