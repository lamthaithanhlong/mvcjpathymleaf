package io.codejournal.springprojects.mvcjpathymeleaf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private long id;

    @Column(name = "s_number", nullable=false)
    private String studentNumber;

    @Column(name = "s_first_name", nullable = false)
    private String firstName;

    @Column(name = "s_last_name", nullable = false)
    private String lastName;

    @Column(name = "s_middle_name")
    private String middleName;

    @Column(name = "cgpa")
    private double cgpa;

    @Column(name = "dateOfEnrollment")
    private int dateOfEnrollment;
}
