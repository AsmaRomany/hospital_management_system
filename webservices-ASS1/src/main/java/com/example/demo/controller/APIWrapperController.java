package com.example.demo.controller;

import com.example.demo.dto.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Mohammed Kharma
 */
@RestController
public class APIWrapperController {
    private final Logger log = LoggerFactory.getLogger(APIWrapperController.class);

    @Autowired
    //@Autowired annotation is used for dependency injection.In spring boot application, all loaded beans are eligible for auto wiring to another bean. The annotation @Autowired in spring boot is used to auto-wire a bean into another bean.
    @Qualifier(value = "restTemplate")
    RestTemplate restTemplate;

//    public APIWrapperController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @GetMapping("/api/doctor")
    public ResponseEntity<Doctor[]> all(@RequestParam(value = "name", defaultValue = "Asma") String name) {
//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Doctor[]> response =
                restTemplate.getForEntity("https://gorest.co.in/public/v2/users", Doctor[].class);
        Doctor[] DoctorList = response.getBody();
        return ResponseEntity.ok().body(DoctorList);
    }
}
