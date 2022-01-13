package com.example.android.Retrofig2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofigClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseurl) {
        OkHttpClient builder = new OkHttpClient.Builder().retryOnConnectionFailure(true).build();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(baseurl).client(builder).addConverterFactory(GsonConverterFactory.create(gson)).build();

        return retrofit;
    }
}
