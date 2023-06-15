package io.codejournal.springprojects.mvcjpathymeleaf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Long id;

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
    private String dateOfEnrollment;

    // This is one to one relationship we need to setup like this
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transcript_id")
    private Transcript primaryTranscript;
}
