package com.example.android.teacheruser;

import com.example.android.spotlightTeacher;

import java.io.Serializable;
import java.util.List;

public class TeacherUser implements Serializable {
    private String name;

    @Override
    public String toString() {
        return "TeacherUser{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherUser(String name) {
        this.name = name;
    }
}
