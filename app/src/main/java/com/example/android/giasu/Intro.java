package com.example.android.giasu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.onboarding_main_layout);
        PaperOnboardingEngine engine = new PaperOnboardingEngine(findViewById(R.id.onboardingRootView), getPaperOnboardingPageData(), this);
        engine.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                Intent login = new Intent(Intro.this, SplashActivity.class);
                startActivity(login);
                finish();
            }
        });
    }

    private ArrayList<PaperOnboardingPage> getPaperOnboardingPageData() {
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Tìm kiếm nhanh chóng",
                "Giúp các bạn tìm kiếm gia sư một cách nhanh chóng và đơn giản nhất.",
                Color.parseColor("#9B90BC"), R.drawable.intro11, R.drawable.ic_baseline_search_w);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Tao công việc",
                "Giúp bạn mở một khóa day học cho riêng mình và quản bá nó đến cho mọi người",
                Color.parseColor("#65B0B4"), R.drawable.intro22, R.drawable.ic_create);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Trao dổi thuận tiên",
                "Giúp bạn lên hệ với gia sư hay gia sư tìm thành viên lớp một cách đơn giản và nhanh chóng",
                Color.parseColor("#678FB4"), R.drawable.intro33, R.drawable.ic_message);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);

        return elements;
    }
}