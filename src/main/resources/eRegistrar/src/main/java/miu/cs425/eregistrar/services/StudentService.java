package miu.cs425.eregistrar.services;

import miu.cs425.eregistrar.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudent(Integer studentId);

    void deleteStudent(Integer studentId);

    void deleteStudent(Student student);

    List<Student> searchStudents(String searchQuery);
}
