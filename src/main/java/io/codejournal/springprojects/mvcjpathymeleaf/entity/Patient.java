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
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
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
    @NotNull(message = "Date of Birth is not empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    // Apply elderly
    @Transient
    private Boolean elderly;

    public Patient(String patientNumber, String firstName, String lastName, LocalDate dateOfBirth) {
        this.patientNumber = patientNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean getElderly() {
        return isElderly();
    }
    public void setElderly(Boolean elderly) {
        if (isElderly()) {
            this.elderly = true;
        } else {
            this.elderly = false;
        }
    }
    private boolean isElderly() {
        var age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age >= 65;
    }
}
