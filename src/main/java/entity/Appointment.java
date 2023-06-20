package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Appointment {
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
}
