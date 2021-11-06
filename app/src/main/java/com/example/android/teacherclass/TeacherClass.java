package com.example.android.teacherclass;

public class TeacherClass {
     private int resourceId;
     private String nameclass;
     private String name;
     private String subject;
     private int local;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getNameclass() {
        return nameclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
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

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public TeacherClass(int resourceId, String nameclass, String name, String subject, int local, String address, String online) {
        this.resourceId = resourceId;
        this.nameclass = nameclass;
        this.name = name;
        this.subject = subject;
        this.local = local;
        this.address = address;
        this.online = online;
    }

    private String address;
     private String online;

}
