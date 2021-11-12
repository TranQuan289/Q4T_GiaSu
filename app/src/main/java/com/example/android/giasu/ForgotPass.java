package com.example.android.giasu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPass extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forgotpass);
    }
}
