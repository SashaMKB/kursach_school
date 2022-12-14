package com.reboticaSchool.School.Manager.controllers;

import com.reboticaSchool.School.Manager.models.Student;
import com.reboticaSchool.School.Manager.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentCardController {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/student-card")
    public String studentCardMain(Model model) {
        return "student-Card-Main";
    }

    @PostMapping("/student-card")
    public String studentCardAdd(@RequestParam String studentFirstName,@RequestParam String studentSecondName,@RequestParam String studentSurName,@RequestParam String studentNum,@RequestParam String studentCourse,@RequestParam String classDay,@RequestParam String classTime, Model model){
        Student student = new Student(studentFirstName,studentSecondName,studentSurName,studentNum,studentCourse,classTime,classDay);
        studentRepository.save(student);
        return "redirect:/";
    }
}
