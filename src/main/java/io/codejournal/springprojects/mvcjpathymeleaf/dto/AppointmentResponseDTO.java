package io.codejournal.springprojects.mvcjpathymeleaf.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentResponseDTO(
        Long appointment,
        LocalDate appointmentDate,
        LocalTime appointmentTime,
        String dentistName,
        String suregeryLocation
) {

}
