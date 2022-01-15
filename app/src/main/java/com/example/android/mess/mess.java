package com.example.android.mess;

public class mess{

    private String name;
    private String content;

    @Override
    public String toString() {
        return "mess{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
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

    public mess(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
