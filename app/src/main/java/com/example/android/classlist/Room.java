package com.example.android.classlist;

import java.io.Serializable;

public class Room implements Serializable {
    private String grade;
    private String subject;
    private String fee;
    private String address;
    private String method;

    @Override
    public String toString() {
        return "Room{" +
                "grade='" + grade + '\'' +
                ", subject='" + subject + '\'' +
                ", fee='" + fee + '\'' +
                ", address='" + address + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
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

    public Room(String grade, String subject, String fee, String address, String method) {
        this.grade = grade;
        this.subject = subject;
        this.fee = fee;
        this.address = address;
        this.method = method;
    }
}