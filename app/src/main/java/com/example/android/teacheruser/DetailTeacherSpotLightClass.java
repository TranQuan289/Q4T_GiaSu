package com.example.android.teacheruser;

import java.io.Serializable;

public class DetailTeacherSpotLightClass implements Serializable {
    private String name;
    private String level;
    private String gender;
    private String address;
    private String subject;
    private String method;

    @Override
    public String toString() {
        return "DetailTeacherSpotLightClass{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", subject='" + subject + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public DetailTeacherSpotLightClass(String name, String level, String gender, String address, String subject, String method) {
        this.name = name;
        this.level = level;
        this.gender = gender;
        this.address = address;
        this.subject = subject;
        this.method = method;
    }
}
