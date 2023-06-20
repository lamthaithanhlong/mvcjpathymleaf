package Service.impl;

import entity.Appointment;
import org.springframework.stereotype.Service;
import repository.AppointmentRepository;
import Service.AppointmentService;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getVIPAppointments() {
        return null;
    }
}
