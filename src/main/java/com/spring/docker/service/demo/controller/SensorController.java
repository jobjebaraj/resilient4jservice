package com.spring.docker.service.demo.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@RestController
@RequestMapping("/api/v1")
public class SensorController {


    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URL
            = "http://localhost:8089/";

    private static final String SENSOR = "SENSOR";

    @GetMapping("/sense")
    @CircuitBreaker(name = SENSOR, fallbackMethod = "sensorFallback")
    ///@Retry(name = SENSOR)
    public String home() throws IOException {

        String result = restTemplate.getForObject("http://192.168.1.191:8099/api/v1/home", String.class);
        return result;
     }


    @GetMapping("/test")
    public String test() throws IOException {

        return "Hello Theorem";
    }


    public String sensorFallback(Exception e) {

        return " Hello From FallBack";
    }
}
