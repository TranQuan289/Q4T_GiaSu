package com.example.android;



public class profile {

    private String id;

    private String email;

    private String pass;

    private String name;

    private String image;

    private String address;

    private String gender;

    private String phone;

    private String dob;

    private String perr;

    public static profile pro;
    public profile(String id, String email, String pass, String name, String image, String address,
                   String gender, String phone, String dob, String perr) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.image = image;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.dob = dob;
        this.perr = perr;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

}


