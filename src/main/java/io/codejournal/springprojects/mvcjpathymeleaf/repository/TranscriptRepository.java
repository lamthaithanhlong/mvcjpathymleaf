package io.codejournal.springprojects.mvcjpathymeleaf.repository;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
