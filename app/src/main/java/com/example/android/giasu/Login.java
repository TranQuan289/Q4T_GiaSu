package com.example.android.giasu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.Account;
import com.example.android.Register.Register;
import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextView register;
    Button btnLogin;
    EditText edtEmail, edtPass;
    String email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.register);
        btnLogin = findViewById(R.id.btnlogin);
        edtEmail = findViewById(R.id.edttxtemail);
        edtPass = findViewById(R.id.txt_pass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = edtEmail.getText().toString().trim();
                pass = edtPass.getText().toString().trim();
                if (email.length() > 0 && pass.length() > 0) {
                    DataClient dataClient = APIUtils.getData();
                    Call<List<Account>> callback = dataClient.LoginData(email, pass);
                    callback.enqueue(new Callback<List<Account>>() {
                        @Override
                        public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                                ArrayList<Account> accountsList = (ArrayList<Account>) response.body();
                            if (accountsList.size() > 0) {
                                Intent login = new Intent(Login.this, MainActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("account", accountsList);
                                startActivity(login);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Account>> call, Throwable t) {
                            Toast.makeText(Login.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(Login.this, Register.class);
                startActivity(register);
            }
        });
    }
}