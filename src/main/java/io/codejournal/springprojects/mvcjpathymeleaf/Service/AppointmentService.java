package Service;

import entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
    public abstract List<Appointment> getVIPAppointments();
}
