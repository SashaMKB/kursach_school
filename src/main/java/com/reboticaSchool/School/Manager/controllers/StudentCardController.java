package com.reboticaSchool.School.Manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentCardController {

    @GetMapping("/student-card")
    public String studentCardMain(Model model) {
        return "student-Card-Main";
    }
}
