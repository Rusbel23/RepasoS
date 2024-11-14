package com.demojavadj.appweb.contollers;

import com.demojavadj.appweb.models.Student;
import com.demojavadj.appweb.services.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/listar")
    public String listAllStudents(Model model) {
        model.addAttribute("title", "Lista de Estudiantes");
        model.addAttribute("listaStudent", studentService.getAllStudents());
        return "pages/list-student";
    }

    @GetMapping("/nuevo")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("title", "Agregar Estudiante");
        model.addAttribute("student", student);
        return "pages/form-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/student/listar";
    }

    @GetMapping("/showUpdateStudent/{id}")
    public String updateStudent(@PathVariable(value = "id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "pages/form-studentActualizar";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/student/listar";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/student/listar";
    }
}
