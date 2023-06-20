package entity;

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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Patient ID is not empty")
    private String patientNumber;
    @Column(nullable = false)
    @NotBlank(message = "firstName is not empty")
    private String firstName;
    @Column(nullable = false)
    @NotBlank(message = "lastName is not empty")
    private String lastName;
    @Column(nullable = false)
    @NotBlank(message = "Date of Birth is not empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}
