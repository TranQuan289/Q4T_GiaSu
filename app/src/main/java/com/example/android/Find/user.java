package com.example.android.Find;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Annotation;

public class user  implements SerializedName{

    @SerializedName("lesson_detail_id")
    @Expose
    private String lessonDetailId;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("hour")
    @Expose
    private String hour;
    @SerializedName("fee")
    @Expose
    private String fee;
    @SerializedName("create_at")
    @Expose
    private String createAt;
    @SerializedName("post_id")
    @Expose
    private String postId;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("mon")
    @Expose
    private String mon;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("pass")
    @Expose
    private String pass;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("perr")
    @Expose
    private String perr;

    public String getLessonDetailId() {
        return lessonDetailId;
    }

    public void setLessonDetailId(String lessonDetailId) {
        this.lessonDetailId = lessonDetailId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPerr() {
        return perr;
    }

    public void setPerr(String perr) {
        this.perr = perr;
    }

    @Override
    public String toString() {
        return "user{" +
                "lessonDetailId='" + lessonDetailId + '\'' +
                ", number='" + number + '\'' +
                ", method='" + method + '\'' +
                ", hour='" + hour + '\'' +
                ", fee='" + fee + '\'' +
                ", createAt='" + createAt + '\'' +
                ", postId='" + postId + '\'' +
                ", _class='" + _class + '\'' +
                ", mon='" + mon + '\'' +
                ", address='" + address + '\'' +
                ", userId='" + userId + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", dob='" + dob + '\'' +
                ", perr='" + perr + '\'' +
                '}';
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public String[] alternate() {
        return new String[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}