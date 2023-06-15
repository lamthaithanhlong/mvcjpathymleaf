package io.codejournal.springprojects.mvcjpathymeleaf.repository;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
