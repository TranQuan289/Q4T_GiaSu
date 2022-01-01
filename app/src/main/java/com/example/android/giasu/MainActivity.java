package com.example.android.giasu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.main_activity);

        mNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.main, new Fragment_home()).commit();

        mNavigationView.setSelectedItemId(R.id.action_home);
        mNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        fragment = new Fragment_home();
                        break;
                    case R.id.action_email:
                        fragment = new Fragment_email();
                        break;
                    case R.id.action_create:
                        fragment = new Fragment_create();
                        break;
                    case R.id.action_proflie:
                        fragment = new Fragment_profile();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main,fragment).commit();
                return true;
            }
        });
    }
}
