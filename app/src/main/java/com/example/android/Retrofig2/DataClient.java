package com.example.android.Retrofig2;

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
}
