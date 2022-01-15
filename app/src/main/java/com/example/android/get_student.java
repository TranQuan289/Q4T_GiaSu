package com.example.android;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class get_student {
    @SerializedName("level")
    @Expose
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
