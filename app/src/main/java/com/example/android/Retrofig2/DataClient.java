package com.example.android.Retrofig2;

import androidx.annotation.FractionRes;

import com.example.android.Account;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DataClient {
    @FormUrlEncoded
    @POST("login.php")
    Call<List<Account>> Logindata(@Field("email") String email, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("register.php")
    Call<String> Register(@Field("name") String name
                            ,@Field("email") String email
                            ,@Field("pass") String pass
                            ,@Field("address") String address
                            ,@Field("gender") String gender
                            ,@Field("phone") String phone
                            ,@Field("dob") String dob
                            ,@Field("perr") String perr
                            ,@Field("level") String level);

    @FormUrlEncoded
    @POST("post.php")
    Call<String> post(@Field("id") String id
                            ,@Field("number") String number
                            ,@Field("method") String method
                            ,@Field("hour") String hour
                            ,@Field("fee") String fee
                            ,@Field("clas") String clas
                            ,@Field("mon") String mon
                            ,@Field("address") String address);
}
