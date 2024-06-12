package com.example.Redis;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ApiService {

    private RestTemplate restTemplate = new RestTemplate();

    public String sendPostRequest(LoginRequest requestJson) {
        String url = "http://localhost:8082/api/test";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoginRequest> request = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        return response.getBody();
    }
}
