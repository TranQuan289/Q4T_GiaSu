package com.example.android.teacherclass;

public class TeacherClass {
    private String grade;
    private String name;
    private String subject;
    private String address;
    private String method;

    public TeacherClass(String grade, String name, String subject, String address, String method) {
        this.grade = grade;
        this.name = name;
        this.subject = subject;
        this.address = address;
        this.method = method;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "TeacherClass{" +
                "grade='" + grade + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", address='" + address + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
