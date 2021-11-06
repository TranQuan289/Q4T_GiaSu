package com.example.android.Find;

public class user {
    private int resourceId;
    private String name;
    private String km;
    private String loai;
    private String mon;
    private String diachi;

    public user(int resourceId, String name, String km, String loai, String mon, String diachi) {
        this.resourceId = resourceId;
        this.name = name;
        this.km = km;
        this.loai = loai;
        this.mon = mon;
        this.diachi = diachi;
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

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
