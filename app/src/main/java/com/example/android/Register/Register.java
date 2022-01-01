package com.example.android.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.giasu.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    Button button;
    RadioButton radioButton1,radioButton2;
    EditText edttxtemail,edttxtpass2;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        button =  findViewById(R.id.btnnext);
        radioButton1 = findViewById(R.id.rb1);
        radioButton2 =  findViewById(R.id.rb2);
        edttxtemail = findViewById(R.id.edttxtemail);
        edttxtpass2 = findViewById(R.id.edttxtpass2);
        String email =edttxtemail.getText().toString();
        String password =edttxtpass2.getText().toString();
//        mAuth = FirebaseAuth.getInstance();
//        mAuth.createUserWithEmailAndPassword("voqqqqqqq@gmail.com"," password")
//                .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//
//                            Toast.makeText(getApplicationContext(), "Thành công",Toast.LENGTH_LONG).show();
//
//                        } else {
//
//                            Toast.makeText(getApplicationContext(), "thất bại",Toast.LENGTH_LONG).show();
//
//                        }
//                    }
//                });
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
    private void createAccount(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(), "Thành công",Toast.LENGTH_LONG).show();

                        } else {

                            Toast.makeText(getApplicationContext(), "thất bại",Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }
    private void reload() { }
    private void updateUI(FirebaseUser user) {

    }
}