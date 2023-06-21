package io.codejournal.springprojects.mvcjpathymeleaf.controller;

import io.codejournal.springprojects.mvcjpathymeleaf.Service.AppointmentService;
import io.codejournal.springprojects.mvcjpathymeleaf.Service.PatientService;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.PatientRequestDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.PatientResponseDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/ams/api"})
public class PatientController {
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @Autowired
    private PatientService patientService;

    @PostMapping(value = {"/new"})
    public ResponseEntity<PatientResponseDTO> registerNewPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        return new ResponseEntity<PatientResponseDTO>(patientService.registerNewPatient(patientRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = {"/edit/{patientId}"})
    public ResponseEntity<PatientRequestDTO> editPatient(@PathVariable Long patientId, @RequestBody PatientRequestDTO patientRequestDTO) throws IllegalAccessException {
        return new ResponseEntity<PatientRequestDTO>(patientService.editPatient(patientId, patientRequestDTO), HttpStatus.OK);
    }
}
