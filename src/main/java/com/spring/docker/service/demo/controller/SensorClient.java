package com.spring.docker.service.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface SensorClient {
    @RequestMapping(method = RequestMethod.GET, value = "")
    String getSensors();

}
