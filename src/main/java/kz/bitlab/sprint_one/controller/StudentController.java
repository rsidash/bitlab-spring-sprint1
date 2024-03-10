package kz.bitlab.sprint_one.controller;

import jakarta.validation.Valid;
import kz.bitlab.sprint_one.entity.Student;
import kz.bitlab.sprint_one.service.StudentService;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("students", StudentService.findAll());

        return "index";
    }

    private String calculateMark(int exam) {
        if (exam >= 90) {
            return "A";
        }

        if (exam >= 75) {
            return "B";
        }

        if (exam >= 60) {
            return "C";
        }

        if (exam >= 50) {
            return "D";
        }

        return "F";
    }

    @PostMapping("/add")
    public String addStudent(
            @Valid Student student,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "addstudent";
        }

        var studentsSize = StudentService.findAll().size();
        student.setId(studentsSize + 1L);
        student.setMark(calculateMark(student.getExam()));

        StudentService.create(student);

        redirectAttributes.addFlashAttribute("successMessage", "Student added successfully!");
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "addstudent";
    }
}
