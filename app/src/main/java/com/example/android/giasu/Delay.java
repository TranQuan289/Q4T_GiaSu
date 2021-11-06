package com.example.android.giasu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Delay extends AppCompatActivity {
    ImageView bg,logo;
    private static int x=3000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_delay);

        logo=(ImageView) findViewById(R.id.logo);
        bg=(ImageView) findViewById(R.id.img);

        logo.animate().translationY(1400).setDuration(1000).setStartDelay(2000);
        logo.animate().translationY(-3000).setDuration(1000).setStartDelay(2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it =new Intent(Delay.this,Intro.class);
                startActivity(it);
            }
        },x);
    }
}
