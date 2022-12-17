package com.reboticaSchool.School.Manager.controllers;

import com.reboticaSchool.School.Manager.models.Student;
import com.reboticaSchool.School.Manager.models.Teacher;
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
public class TeacherCardController {
    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping("/teacher-card")
    public String help(Model model){
        return "teacher-card";
    }

    @PostMapping("/teacher-card")
    public String teacherCardAdd(@RequestParam String firstName,
                                 @RequestParam String secondName,
                                 @RequestParam String surName,
                                 @RequestParam String phoneNumber,Model model){
        Teacher teacher = new Teacher(firstName,secondName,surName,phoneNumber);
        teacherRepository.save(teacher);
        return "redirect:/";
    }

    @GetMapping("/all-teacher-card")
    public String home(Model model) {
        Iterable<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers",teachers);
        return "/see-teachers-card";
    }



    @GetMapping("/teacher-card/{id}")
    public String teacherDetails(@PathVariable(value = "id") long id, Model model) {
        if (!teacherRepository.existsById(id)) {
            return "redirect:/";
        }

        Optional<Teacher> teacher = teacherRepository.findById(id);
        ArrayList<Teacher> res = new ArrayList<>();
        teacher.ifPresent(res::add);
        model.addAttribute("teacher",res);
        return "/teacher-details";
    }

    @GetMapping("/teacher-card/{id}/edit")
    public String teacherEdit(@PathVariable(value = "id") long id, Model model) {
        if (!teacherRepository.existsById(id)) {
            return "redirect:/";
        }

        Optional<Teacher> teacher = teacherRepository.findById(id);
        ArrayList<Teacher> res = new ArrayList<>();
        teacher.ifPresent(res::add);
        model.addAttribute("teacher",res);
        return "teacher-edit";
    }
    @PostMapping("/teacher-card/{id}/edit")
    public String teacherCardUpdate(@PathVariable(value = "id") long id,
                                    @RequestParam String firstName,
                                    @RequestParam String secondName,
                                    @RequestParam String surName,
                                    @RequestParam String phoneNumber,Model model){
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        teacher.setFirstName(firstName);
        teacher.setFirstName(secondName);
        teacher.setFirstName(surName);
        teacher.setFirstName(phoneNumber);
        teacherRepository.save(teacher);
        return "redirect:/all-teacher-card";
    }
    @PostMapping("/teacher-card/{id}/remove")
    public String studentCardDelete(@PathVariable(value = "id") long id,Model model){
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        teacherRepository.delete(teacher);
        return "redirect:/all-teacher-card";
    }




}
