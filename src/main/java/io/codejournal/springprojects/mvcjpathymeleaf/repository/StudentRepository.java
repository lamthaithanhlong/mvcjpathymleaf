package io.codejournal.springprojects.mvcjpathymeleaf.repository;

import java.util.UUID;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
}