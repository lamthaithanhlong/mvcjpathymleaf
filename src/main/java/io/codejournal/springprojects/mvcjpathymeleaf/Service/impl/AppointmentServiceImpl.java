package io.codejournal.springprojects.mvcjpathymeleaf.Service.impl;

import io.codejournal.springprojects.mvcjpathymeleaf.Service.AppointmentService;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Appointment;
import org.springframework.stereotype.Service;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getVIPAppointments()  {
        return null;
    }
}
