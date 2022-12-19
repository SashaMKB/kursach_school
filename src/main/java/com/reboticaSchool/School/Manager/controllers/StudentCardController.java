package com.reboticaSchool.School.Manager.controllers;

import com.reboticaSchool.School.Manager.models.Client;
import com.reboticaSchool.School.Manager.models.Student;
import com.reboticaSchool.School.Manager.models.Teacher;
import com.reboticaSchool.School.Manager.repo.ClientRepository;
import com.reboticaSchool.School.Manager.repo.StudentRepository;
import com.reboticaSchool.School.Manager.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class StudentCardController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping("/student-card")
    public String studentCardMain(Model model) {

        return "student-Card-Main";
    }

    @PostMapping("/student-card")
    public String studentCardAdd(@RequestParam String studentFirstName,
                                 @RequestParam String studentSecondName,
                                 @RequestParam String studentSurName,
                                 @RequestParam String studentNum,
                                 @RequestParam String studentCourse,
                                 @RequestParam String classDay,
                                 @RequestParam String classTime,
                                 @RequestParam String clientName,
                                 @RequestParam String clientLastName,
                                 @RequestParam String clientSurname,
                                 @RequestParam String clientNum,
                                 @RequestParam(required = false)  Teacher teacherId,    // < - ?
                                 Model model){
        Student student = new Student(studentFirstName, studentSecondName, studentSurName, studentNum, studentCourse, classTime, classDay, teacherId);
        Client client = new Client(clientName,clientLastName,clientSurname,clientNum);
        studentRepository.save(student);
        clientRepository.save(client);
        return "redirect:/";
    }
    @GetMapping("/student-card/{id}")
    public String studentDetails(@PathVariable(value = "id") long id, Model model) {
        if (!studentRepository.existsById(id)) {
            return "redirect:/";

    }

        Optional<Student> student = studentRepository.findById(id);
        ArrayList<Student> res = new ArrayList<>();
        student.ifPresent(res::add);
        model.addAttribute("student",res);
        return "/student-details";
}

    @GetMapping("/student-card/{id}/edit")
    public String studentEdit(@PathVariable(value = "id") long id, Model model) {
        if (!studentRepository.existsById(id)) {
            return "redirect:/";
        }

        Optional<Student> student = studentRepository.findById(id);
        ArrayList<Student> res = new ArrayList<>();
        student.ifPresent(res::add);
        model.addAttribute("student",res);
        return "student-edit";
    }

    @PostMapping("/student-card/{id}/edit")
    public String studentCardUpdate(@PathVariable(value = "id") long id,
                                    @RequestParam String studentFirstName,
                                    @RequestParam String studentSecondName,
                                    @RequestParam String studentSurName,
                                    @RequestParam String studentNum,
                                    @RequestParam String studentCourse,
                                    @RequestParam String classDay,
                                    @RequestParam String classTime,
                                    Model model){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setStudentFirstName(studentFirstName);
        student.setStudentSecondName(studentSecondName);
        student.setStudentSurName(studentSurName);
        student.setStudentNum(studentNum);
        student.setStudentCourse(studentCourse);
        student.setClassDay(classDay);
        student.setClassTime(classTime);
        studentRepository.save(student);
        return "redirect:/";
    }

    @PostMapping("/student-card/{id}/remove")
    public String studentCardDelete(@PathVariable(value = "id") long id,Model model){
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
        return "redirect:/";
    }
}
