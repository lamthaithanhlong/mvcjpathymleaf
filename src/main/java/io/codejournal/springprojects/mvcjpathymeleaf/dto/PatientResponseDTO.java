package io.codejournal.springprojects.mvcjpathymeleaf.dto;

import java.time.LocalDate;

public record PatientResponseDTO (
        Integer patientId,
        String patientNumber,
        String firstName,
        String lastName,
        LocalDate dateOfBirth
        ) {}