package com.reboticaSchool.School.Manager.models;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(columnDefinition = "1")
    private Teacher teacher;


    public Student() {
    }

    public Student(String studentFirstName, String studentSecondName, String studentSurName, String studentNum, String studentCourse, String classDay, String classTime,Teacher teacher) {
        this.teacher = teacher;
        this.studentFirstName = studentFirstName;
        this.studentSecondName = studentSecondName;
        this.studentSurName = studentSurName;
        this.studentNum = studentNum;
        this.studentCourse = studentCourse;
        this.classDay = classDay;
        this.classTime = classTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    private String studentFirstName,studentSecondName,studentSurName,studentNum,studentCourse,classDay,classTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentSecondName() {
        return studentSecondName;
    }

    public String getStudentSurName() {
        return studentSurName;
    }

    public void setStudentSurName(String studentSurName) {
        this.studentSurName = studentSurName;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public void setStudentSecondName(String studentSecondName) {
        this.studentSecondName = studentSecondName;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getClassDay() {
        return classDay;
    }

    public void setClassDay(String classDay) {
        this.classDay = classDay;
    }

    public String getClassTime() {
        return classTime;
    }


    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }
}
