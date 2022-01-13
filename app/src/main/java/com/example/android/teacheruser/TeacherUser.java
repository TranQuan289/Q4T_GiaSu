package com.example.android.teacheruser;

import com.example.android.spotlightTeacher;

import java.io.Serializable;
import java.util.List;

public class TeacherUser implements Serializable {
    private int resourceId;
    private String name;

    @Override
    public String toString() {
        return "TeacherUser{" +
                "resourceId=" + resourceId +
                ", name='" + name + '\'' +
                '}';
    }

    public TeacherUser(int avt, List<spotlightTeacher> accountsList) {
    }


    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherUser(int resourceId, String name) {
        this.resourceId = resourceId;
        this.name = name;
    }
}
