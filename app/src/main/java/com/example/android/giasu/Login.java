package com.example.android.giasu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.Register.Register;

public class Login extends AppCompatActivity {

    TextView register,forgot;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
         register = findViewById(R.id.register);
        forgot =  findViewById(R.id.forgotpass);
        btnLogin = findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(Login.this,MainActivity.class);
                startActivity(main);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(Login.this, Register.class);
                startActivity(register);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgot = new Intent(Login.this, ForgotPass.class);
                startActivity(forgot);
            }
        });
    }
}