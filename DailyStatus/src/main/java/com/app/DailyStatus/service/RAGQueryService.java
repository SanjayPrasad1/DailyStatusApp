//package com.app.DailyStatus.service;
//
//import com.app.DailyStatus.model.RAGQuery;
//import com.app.DailyStatus.model.StatusUpdate;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class RAGQueryService {
//
//    private final RestTemplate restTemplate;
//    private final ObjectMapper objectMapper;
//
//    public RAGQueryService(RestTemplate restTemplate, ObjectMapper objectMapper) {
//        this.restTemplate = restTemplate;
//        this.objectMapper = objectMapper;
//    }
//
//    public String getRelevantStatus(String prompt, List<String> statuses) throws JsonProcessingException {
//        // Define the FastAPI URL
//        String fastAPIUrl = "http://127.0.0.1:8000/rag/query";
//
//        // Prepare the request body (JSON)
//        RAGQuery request = new RAGQuery(prompt, statuses);
//        String response = restTemplate.postForObject(fastAPIUrl, request, String.class);
//
//        // Extract relevant status from the response (assuming it's in a simple format)
//        return response; // Adjust this based on the actual response format
//    }
//}
