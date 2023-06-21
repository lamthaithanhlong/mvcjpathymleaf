package io.codejournal.springprojects.mvcjpathymeleaf;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Appointment;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.AppointmentRepository;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.PatientRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class MvcjpathymeleafApplication {
	@Autowired
	private final AppointmentRepository appointmentRepository;

	@Autowired
	private final PatientRepository patientRepository;

	public MvcjpathymeleafApplication(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
		this.appointmentRepository = appointmentRepository;
		this.patientRepository = patientRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcjpathymeleafApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializeStudents() {
		return args -> {
			// Add new patient
			Patient patient = new Patient();
			patient.setPatientId(1);
			patient.setPatientNumber("EP117");
			patient.setFirstName("John");
			patient.setLastName("Tambun");
			patient.setDateOfBirth(LocalDate.parse("1958-03-26"));

			//Add first appointment
			Appointment appointment = new Appointment();
			appointment.setAppointmentId(1L);
			appointment.setAppointmentDate(LocalDate.parse("2023-09-01"));
			appointment.setAppointmentTime(LocalTime.of(10,00,00));
			appointment.setDentistName("Job Lecture");
			appointment.setSurgeryLocation("D4 Med Plaza");
			appointment.setPatient(patient);

			//Add second appointment
			Appointment appointment1 = new Appointment();
			appointment1.setAppointmentId(2L);
			appointment1.setAppointmentDate(LocalDate.parse("2023-09-01"));
			appointment1.setAppointmentTime(LocalTime.of(9,00,00));
			appointment1.setDentistName("Job Lecture");
			appointment1.setSurgeryLocation("D3 Med Plaza");
			appointment1.setPatient(patient);

			//Save all appointment
			appointmentRepository.saveAll(Arrays.asList(appointment,appointment1));
		};
	}
}
