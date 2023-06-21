package io.codejournal.springprojects.mvcjpathymeleaf.controller;

import io.codejournal.springprojects.mvcjpathymeleaf.Service.AppointmentService;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.AppointmentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ={"/ams/api/appointment"})
public class AppointmentController {
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    private AppointmentService appointmentService;

    @GetMapping(value={"/vip/list"})
    public ResponseEntity<List<AppointmentResponseDTO>> listVipAppointment() {
        return ResponseEntity.ok(appointmentService.getVIPAppointments());
    }
}
