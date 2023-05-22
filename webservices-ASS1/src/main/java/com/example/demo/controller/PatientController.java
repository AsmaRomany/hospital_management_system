package com.example.demo.controller;

import com.example.demo.dto.PatientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientController {
    @GetMapping(value = "/patient")
    public PatientDto getSPatient() {
        return new PatientDto("Asma ", "Romany");
    }

    @GetMapping(value = "/patients")
    public List<PatientDto> getSCPatients() {
        List<PatientDto> patientList = new ArrayList<PatientDto>();
        for (int i = 0; i < 5; i++) {
            patientList.add(new PatientDto("name" + i, "lastname" + i));
        }
        return patientList;
    }
    @GetMapping(value = "/patient/V2")
    public ResponseEntity<PatientDto> getSPatientV2() {
        return ResponseEntity.ok(new PatientDto("Asma", "Romany"));
    }
    @GetMapping(value = "/patient/{firstName}/{lastName}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return ResponseEntity.ok(new PatientDto(firstName, lastName));
    }
    @GetMapping(value = "/patientRequestParam")
    public ResponseEntity<PatientDto> getPatientRequestParam(@RequestParam("firstName") String firstName,
                                                              @RequestParam(name = "lastName") String lastName) {
        return ResponseEntity.ok(new PatientDto(firstName, lastName));
    }
}
