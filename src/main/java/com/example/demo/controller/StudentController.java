package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/add")
    public String getStudent(){
        return "/student/add";
    }

    @PostMapping("/student/add")
    public String saveStudent(Student student){
        studentService.save(student);
        return "redirect:/student/add";
    }
@RequestMapping("/student/list")
    public String ListStudent(Model model){
        model.addAttribute("students", studentService.listAllStudent());
        return "student/list";
}


}
