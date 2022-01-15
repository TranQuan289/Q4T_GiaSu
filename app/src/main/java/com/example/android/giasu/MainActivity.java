package com.example.android.giasu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mNavigationView;


    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_MESS = 1;
    private static final int FRAGMENT_CREATE = 1;
    private static final int FRAGMENT_PROFILE = 1;
    private int mCurrentFragment = FRAGMENT_HOME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.main_activity);

        mNavigationView = findViewById(R.id.bottomNavigationView);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("account");

        getSupportFragmentManager().beginTransaction().replace(R.id.main, new Fragment_home()).commit();

        mNavigationView.setSelectedItemId(R.id.action_home);

        Intent data = MainActivity.this.getIntent();
        Bundle bundle= data.getBundleExtra("login_data");

        Fragment fragment = new update_profile();



        mNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        fragment = new Fragment_home();
                        mCurrentFragment = FRAGMENT_HOME;
                        break;
                    case R.id.action_email:
                        fragment = new Fragment_mess();
                        mCurrentFragment = FRAGMENT_MESS;
                        break;
                    case R.id.action_create:
                        fragment = new Fragment_create();
                        fragment.setArguments(bundle);
                        mCurrentFragment = FRAGMENT_CREATE;
                        break;
                    case R.id.action_proflie:
                        fragment = new Fragment_profile();
                        fragment.setArguments(bundle);
                        mCurrentFragment = FRAGMENT_PROFILE;
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = null;
        if (mCurrentFragment != FRAGMENT_HOME) {
            fragment = new Fragment_home();
            getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
            mCurrentFragment = FRAGMENT_HOME;
            return;
        }
        super.onBackPressed();
    }
}
