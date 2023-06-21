package io.codejournal.springprojects.mvcjpathymeleaf.Service;

import io.codejournal.springprojects.mvcjpathymeleaf.dto.PatientRequestDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.PatientResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {
    PatientResponseDTO registerNewPatient(PatientRequestDTO patientRequestDTO);

    PatientRequestDTO editPatient(Long patientId, PatientRequestDTO patientRequestDTO) throws IllegalAccessException;

    PatientResponseDTO deletePatient(Long patientId);
}
