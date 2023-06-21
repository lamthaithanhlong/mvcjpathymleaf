package io.codejournal.springprojects.mvcjpathymeleaf.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    @Column(nullable = false)
    @NotNull(message = "Appointment Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;
    @Column(nullable = false)
    @NotNull(message = "Appointment Time is required")
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime appointmentTime;
    @Column(nullable = false)
    @NotNull(message = "dentist name is required")
    private String dentistName;
    @Column(nullable = false)
    @NotNull(message = "surgery Location is required")
    private String surgeryLocation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Transient
    private Boolean vip;

    @Transient
    private Boolean upcomming;

    public Boolean isVip() {
        return (patient.getElderly());
    }
    public Boolean isUpcomming() {
        return (!appointmentDate.isBefore(LocalDate.now()));
    }
}
