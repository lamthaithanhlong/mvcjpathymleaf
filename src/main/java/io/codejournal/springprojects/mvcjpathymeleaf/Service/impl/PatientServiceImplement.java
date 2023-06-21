package io.codejournal.springprojects.mvcjpathymeleaf.Service.impl;

import io.codejournal.springprojects.mvcjpathymeleaf.Service.PatientService;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.PatientRequestDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.PatientResponseDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Patient;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImplement implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImplement(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientResponseDTO registerNewPatient(PatientRequestDTO patientRequestDTO) {
        var patient = new Patient(
                patientRequestDTO.patientNumber(),
                patientRequestDTO.firstName(),
                patientRequestDTO.lastName(),
                patientRequestDTO.dateOfBirth()
        );
        var newPatient = patientRepository.save(patient);
        return new PatientResponseDTO(
                newPatient.getPatientId(),
                newPatient.getPatientNumber(),
                newPatient.getFirstName(),
                newPatient.getLastName(),
                newPatient.getDateOfBirth()
        );
    }
    @Override
    public PatientRequestDTO editPatient(Long patientId, PatientRequestDTO patientRequestDTO) {
        Patient existingPatient = patientRepository.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        existingPatient.setPatientNumber(patientRequestDTO.patientNumber());
        existingPatient.setFirstName(patientRequestDTO.firstName());
        existingPatient.setLastName(patientRequestDTO.lastName());
        existingPatient.setDateOfBirth(patientRequestDTO.dateOfBirth());

        Patient updatedPatient = patientRepository.save(existingPatient);
        return new PatientRequestDTO(
                updatedPatient.getPatientId(),
                updatedPatient.getPatientNumber(),
                updatedPatient.getFirstName(),
                updatedPatient.getLastName(),
                updatedPatient.getDateOfBirth()
        );
    }
}
