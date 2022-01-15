package com.example.android.Retrofig2;

public class APIUtils {
    public static final String baseurl="http://192.168.99.2/GiaSu/";
    public static DataClient getData(){
        return RetrofigClient.getClient(baseurl).create(DataClient.class);
    }
}
