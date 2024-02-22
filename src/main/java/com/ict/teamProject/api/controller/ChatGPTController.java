package com.ict.teamProject.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:3333")
public class ChatGPTController {
	
	 @Value("${openai.api.key}")
	    private String apiKey;
	
    @PostMapping("/chatgpt")
    public ResponseEntity<String> chatGPT(@RequestBody Map<String, String> request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer" + apiKey);

        String model = "gpt-3.5-turbo";
        String systemMessage = "You are Helthy-Real's customer service chatbot.";
        String userMessage = request.get("transcript");
        
        Map<String, Object> body = new HashMap<>();
        body.put("model", model);
        body.put("messages", List.of(
                Map.of("role", "system", "content", systemMessage),
                Map.of("role", "user", "content", userMessage)
        ));
        System.out.println("안녕 싸이버거 내일부터 단품 시켜도 세트로 주는 이벤트 게시");
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("https://api.openai.com/v1/chat/completions", entity, String.class);

        return response;
    }
}
