package io.codejournal.springprojects.mvcjpathymeleaf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transcript")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transcript_id")
    private Long transcriptId;

    @Column(name = "degree_title")
    private String degreeTitle;

    // This is one to one relationship
    @OneToOne(mappedBy = "primaryTranscript", cascade = CascadeType.ALL)
    private Student student;
}
