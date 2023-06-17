package io.codejournal.springprojects.mvcjpathymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @GetMapping("/students/")
    public String index() {
        return "redirect:list";
    }

    @GetMapping("students/list")
    public String getStudents() {
        return "student/list";
    }
}
