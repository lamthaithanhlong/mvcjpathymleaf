package miu.cs425.eregistrar.controllers;

import miu.cs425.eregistrar.models.Student;
import miu.cs425.eregistrar.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/eregistra/student/list", "/student/list"})
    private ModelAndView listStudents() {
        List<Student> students = studentService.getAllStudents();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("noStudents", students.size());

        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eregistra/student/new", "/student/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/edit";
    }

    @PostMapping(value = {"/eregistra/student/new", "/student/new"})
    public String addNewStudent(@ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistra/student/list";
    }

    @GetMapping(value = {"/eregistra/student/edit/{studentId}", "/student/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        Student student = studentService.getStudent(studentId).orElse(null);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/eregistra/student/edit", "/student/edit"})
    public String updateStudent(@ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistra/student/list";
    }

    @GetMapping(value = {"/eregistra/student/delete/{studentId}", "/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId, Model model) {
        studentService.deleteStudent(studentId);
        return "redirect:/eregistra/student/list";
    }

    @GetMapping(value = {"/eregistra/student/search", "/student/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("noStudents", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
}
