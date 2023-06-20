package io.codejournal.springprojects.mvcjpathymeleaf.controller;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Student;
import io.codejournal.springprojects.mvcjpathymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentApiController {
    private StudentService studentService;
    @Autowired
    public StudentApiController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/students/list")
    public List<Student> getAllStudents() {
        return studentService.getListStudent();
    }
}
