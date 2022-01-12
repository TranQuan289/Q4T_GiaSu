package com.example.android;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

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
@SerializedName("address")
@Expose
private String address;
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