package com.example.android.classlist1;
import java.io.Serializable;

public class Room1 implements Serializable {
    private String grade;
    private String name;
    private String fee;
    private String address;
    private String method;

    public String getGrade() {
        return grade;
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

    public Room1(String grade, String name, String fee, String address, String method) {
        this.grade = grade;
        this.name = name;
        this.fee = fee;
        this.address = address;
        this.method = method;
    }

    @Override
    public String toString() {
        return "Room1{" +
                "grade='" + grade + '\'' +
                ", name='" + name + '\'' +
                ", fee='" + fee + '\'' +
                ", address='" + address + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
