package miu.cs425.eregistrar.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @NotNull
    @NotEmpty
    private String studentNumber;

    @NotNull
    @NotEmpty
    private String firstName;

    private String middleName;

    @NotNull
    @NotEmpty
    private String lastName;

    private Double cgpa;

    @NotNull
    @NotEmpty
    private LocalDate enrollmentDate;

    @NotEmpty
    private Boolean isInternational;
}
