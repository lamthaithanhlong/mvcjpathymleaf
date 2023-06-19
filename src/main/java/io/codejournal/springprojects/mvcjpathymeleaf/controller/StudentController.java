package io.codejournal.springprojects.mvcjpathymeleaf.controller;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Student;
import io.codejournal.springprojects.mvcjpathymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    static final String DEFAULT_PAGE_SIZE = "3";
    private StudentService studentService;

    @Autowired
    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/")
    public String index() {
        return "redirect:list";
    }
    @GetMapping("/students/list")
    public String getStudents(final Model model, @RequestParam(value = "page",defaultValue = "0") final int pageNumber,@RequestParam(value = "size",defaultValue = DEFAULT_PAGE_SIZE + "") final int pageSize) {
        model.addAttribute("message","Hello world in Thymleaf!!!");
        final Page<Student> page = studentService.getStudents(pageNumber,pageSize);
        final int currentPage = page.getNumber();
        final int previousPage = page.hasPrevious() ? currentPage -1 : -1;
        final int nextPage = page.hasNext() ? currentPage + 1 : -1;
        model.addAttribute("students", page.getContent());
        model.addAttribute("previousPage", previousPage);
        model.addAttribute("nextPage", nextPage);
        return "students/list";
    }

    @GetMapping("/students/add")
    public String add() {
        return "students/add";
    }

    @GetMapping("/students/view")
    public String view() {
        return "students/view";
    }

    @GetMapping("/students/edit")
    public String edit() {
        return "students/edit";
    }

    @GetMapping("/students/delete")
    public String delete() {
        return "students/delete";
    }

}
