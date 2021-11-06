package com.example.android.classlist;

public class Room {
    private String nameclass;
    private String subject;
    private String money;
    private int resourceId;
    private String area;

    public String getNameclass() {
        return nameclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public Room(String nameclass, String subject, String money, int resourceId, String area, String online) {
        this.nameclass = nameclass;
        this.subject = subject;
        this.money = money;
        this.resourceId = resourceId;
        this.area = area;
        this.online = online;
    }

    private String online;

}
