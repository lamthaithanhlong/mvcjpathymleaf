package io.codejournal.springprojects.mvcjpathymeleaf.entity;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "s_id")
    private UUID id;

    @Column(name = "s_first_name")
    private String firstName;

    @Column(name = "s_last_name")
    private String lastName;
}
