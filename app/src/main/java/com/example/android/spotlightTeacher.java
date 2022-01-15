package com.example.android;


import java.io.Serializable;

public class spotlightTeacher implements Serializable {

    String name;

    @Override
    public String toString() {
        return "spotlightTeacher{" +
                "name='" + name + '\'' +
                '}';
    }

    public spotlightTeacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
