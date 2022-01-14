package com.example.android;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class profile_static {
    private static String id;

    private static String email;

    private static String pass;

    private static String name;

    private static String image;

    private static String address;

    private static String gender;

    private static String phone;

    private static String dob;

    private static String perr;


    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        profile_static.id = id;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        profile_static.email = email;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        profile_static.pass = pass;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        profile_static.name = name;
    }

    public static String getImage() {
        return image;
    }

    public static void setImage(String image) {
        profile_static.image = image;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        profile_static.address = address;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        profile_static.gender = gender;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        profile_static.phone = phone;
    }

    public static String getDob() {
        return dob;
    }

    public static void setDob(String dob) {
        profile_static.dob = dob;
    }

    public static String getPerr() {
        return perr;
    }

    public static void setPerr(String perr) {
        profile_static.perr = perr;
    }
}
