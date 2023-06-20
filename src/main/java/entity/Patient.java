package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Patient {
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
    @JoinColumn(name = "appointment_id")
    private Patient patient;
}
