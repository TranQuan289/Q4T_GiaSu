package com.example.android.giasu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    ImageView bg, logo;
    private static int x = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        }, 1000);
    }

    private void nextActivity() {
//        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
//        if (currentUser == null) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
//        } else {
//            checkUser();
//        }
    }
//    private void checkUser() {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String email = user.getEmail();
//        String[] emailCopy = email.split("@");
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("user/"+emailCopy[0]+"/permission");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
//                if(value.compareTo("student") == 0){
//                    startActivity(new Intent(SplashActivity.this, MainStudentActivity.class));
//                    finishAffinity();
//                }else if(value.compareTo("teacher") == 0){
//                    Intent intent = new Intent(SplashActivity.this, MainTeacherActivity.class);
//                    startActivity(intent);
//                    finishAffinity();
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError error) {
//            }
//        });
}
