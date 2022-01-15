package com.example.android.Retrofig2;

import androidx.annotation.FractionRes;

import com.example.android.Account;
import com.example.android.tutar;

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
    @POST("profile.php")
    Call<List<Account>> profile(@Field("id") String id);

    @FormUrlEncoded
    @POST("update_profile.php")
    Call<String> update_profilr(@Field("name") String name

            ,@Field("perr") String perr
            ,@Field("phone") String phone
            ,@Field("gender") String gender
            ,@Field("address") String address
            ,@Field("id") String id
            ,@Field("dob") String dob);

    @FormUrlEncoded
    @POST("change_pass.php")
    Call<String> change_pass (@Field("id") String id

            ,@Field("pass") String pass
            ,@Field("pass_old") String pass_old);

    @FormUrlEncoded
    @POST("get_tutor.php")
    Call<List<tutar>> get_tutor (@Field("id") String id);


}
