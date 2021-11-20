package com.example.android.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.giasu.R;

public class Register extends AppCompatActivity {
    Button button;
    RadioButton radioButton1,radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        button = (Button) findViewById(R.id.btnnext);
        radioButton1 = (RadioButton) findViewById(R.id.rb1);
        radioButton2 = (RadioButton) findViewById(R.id.rb2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton1.isChecked()){
                    Intent dkgs = new Intent(Register.this, Register_Teacher.class);
                    startActivity(dkgs);
                }else if (radioButton2.isChecked()){
                    Intent dkhs = new Intent(Register.this, Register_User.class);
                    startActivity(dkhs);
                }else{
                    Toast.makeText(getApplicationContext(), "Vui lòng chọn?",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}