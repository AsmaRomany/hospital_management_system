package com.example.demo.controller;

import com.example.demo.dto.PatientDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Mohammed Kharma
 */
@RestController
public class HomeController {

    @GetMapping(value = "/")
    public PatientDto home() {
        return new PatientDto("Asma", "Romany");
    }
}
