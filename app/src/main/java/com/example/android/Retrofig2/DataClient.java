package com.example.android.Retrofig2;

import com.example.android.Account;
import com.example.android.classlist.Room;
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

    @GET("spotlightTeacher.php")
    Call<List<TeacherUser>> getSpotlightTeacher();

    @GET("roomList.php")
    Call<List<Room>> getRoomList();
}
