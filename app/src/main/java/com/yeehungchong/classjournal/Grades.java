package com.yeehungchong.classjournal;

import java.io.Serializable;

public class Grades implements Serializable {
    private String grades;


    public Grades(String grades) {
        this.grades = grades;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }


}
