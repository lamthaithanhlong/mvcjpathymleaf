package io.codejournal.springprojects.mvcjpathymeleaf.Service.impl;

import io.codejournal.springprojects.mvcjpathymeleaf.Service.AppointmentService;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.AppointmentResponseDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.PatientResponseDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Appointment;
import org.springframework.stereotype.Service;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.AppointmentRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<AppointmentResponseDTO> getVIPAppointments()  {
        return appointmentRepository.findAll()
                .stream()
                .filter(Appointment::isVip)
                .sorted(Comparator.comparing(Appointment::getAppointmentDate)
                        .thenComparing(Appointment::getAppointmentTime))
                .map(appointment -> new AppointmentResponseDTO(
                        appointment.getAppointmentId(),
                        appointment.getAppointmentDate(),
                        appointment.getAppointmentTime(),
                        appointment.getDentistName(),
                        appointment.getSurgeryLocation(),
                        new PatientResponseDTO(
                                appointment.getPatient().getPatientId(),
                                appointment.getPatient().getPatientNumber(),
                                appointment.getPatient().getFirstName(),
                                appointment.getPatient().getLastName(),
                                appointment.getPatient().getDateOfBirth()
                        )
                )).toList();
    }

    @Override
    public List<AppointmentResponseDTO> getUpcommingAppointment() {
        return appointmentRepository.findAll()
                .stream()
                .filter(Appointment::isUpcomming)
                .sorted(Comparator.comparing(Appointment::getAppointmentDate)
                        .thenComparing(Appointment::getAppointmentTime))
                .map(appointment -> new AppointmentResponseDTO(
                        appointment.getAppointmentId(),
                        appointment.getAppointmentDate(),
                        appointment.getAppointmentTime(),
                        appointment.getDentistName(),
                        appointment.getSurgeryLocation(),
                        new PatientResponseDTO(
                                appointment.getPatient().getPatientId(),
                                appointment.getPatient().getPatientNumber(),
                                appointment.getPatient().getFirstName(),
                                appointment.getPatient().getLastName(),
                                appointment.getPatient().getDateOfBirth()
                        )
                )).toList();
    }
}
