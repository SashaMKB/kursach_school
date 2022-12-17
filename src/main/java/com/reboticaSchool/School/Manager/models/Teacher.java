package com.reboticaSchool.School.Manager.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Student> students;

    public Teacher() {
    }

    public Teacher(String firstName, String secondName, String surName, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
    }

    private String firstName,secondName,surName,phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
