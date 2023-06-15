package io.codejournal.springprojects.mvcjpathymeleaf.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @NotNull(message = "Student ID not allow to be null")
    private String studentNumber;

    @Column(name = "s_first_name", nullable = false)
    @NotNull(message = "Student first name not allow to be null")
    private String firstName;

    @Column(name = "s_last_name", nullable = false)
    private String lastName;

    @Column(name = "s_middle_name")
    private String middleName;

    @Column(name = "cgpa")
    @NotNull(message = "cgpa not allow to be null")
    private double cgpa;

    @Column(name = "dateOfEnrollment")
    @NotNull(message = "date of enrollment not allow to be null")
    private String dateOfEnrollment;

    // This is one to one relationship we need to setup like this
    // if you delete the owning entity <student>, the associated entity <transcript> will also be deleted.
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    private Transcript transcript;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();
}
