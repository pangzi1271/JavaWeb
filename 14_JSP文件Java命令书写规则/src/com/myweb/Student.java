package com.myweb;

public class Student {
    private int stuId;
    private String stuName;
    private String stuGender;
    private int stuAge;

    public Student() {
    }

    public Student(int stuId, String stuName, String stuGender, int stuAge) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuAge = stuAge;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }
}
