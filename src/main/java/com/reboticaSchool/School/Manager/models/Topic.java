package com.reboticaSchool.School.Manager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name,numofless;

    public Topic() {
    }

    public Topic(String name, String numofless) {
        this.name = name;
        this.numofless = numofless;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumofless() {
        return numofless;
    }

    public void setNumofless(String numofless) {
        this.numofless = numofless;
    }
}
