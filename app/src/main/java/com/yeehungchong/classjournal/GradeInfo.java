package com.yeehungchong.classjournal;

public class GradeInfo {
    private int week;
    private String title;
    private String grade;

    public GradeInfo(int week, String title, String grade) {
        this.week = week;
        this.title = title;
        this.grade = grade;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }






}
