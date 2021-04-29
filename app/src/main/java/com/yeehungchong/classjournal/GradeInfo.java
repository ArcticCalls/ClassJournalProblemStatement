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

    public String getTitle() {
        return title;
    }

    public String getGrade() {
        return grade;
    }

}
