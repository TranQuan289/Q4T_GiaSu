package com.example.android.mess;

public class mess {
    private int img1;
    private String name;
    private String content;
    private int img2;

    public mess(int img1, String name, String content, int img2) {
        this.img1 = img1;
        this.name = name;
        this.content = content;
        this.img2 = img2;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }
}
