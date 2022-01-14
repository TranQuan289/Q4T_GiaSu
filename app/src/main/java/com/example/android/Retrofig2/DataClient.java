package com.example.android.Retrofig2;

import com.example.android.Account;
import com.example.android.Find.user;
import com.example.android.classlist.Room;
import com.example.android.classlist1.Room1;
import com.example.android.spotlightTeacher;
import com.example.android.teacheruser.TeacherUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface DataClient {
    @FormUrlEncoded
    @POST("login.php")
    Call<List<Account>> LoginData(@Field("email") String email, @Field("pass") String pass);

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

    @GET("spotlightTeacher.php")
    Call<List<TeacherUser>> getSpotlightTeacher();

    @GET("roomList.php")
    Call<List<Room>> getRoomList();
    @GET("roomList.php")
    Call<List<Room1>> getRoomList1();

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

    @FormUrlEncoded
    @POST("find.php")
    Call<List<user>> find(@Field("info") String info, @Field("mon") String mon, @Field("lop") String lop);
}
