package com.example.android.giasu;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.android.profile_static;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextView register;
    Button btnlogin;
    EditText edtemail,edtpass;
    String email,pass;
    public static String id="1";
    ArrayList<Account> accountArrayList  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        TextView register = (TextView) findViewById(R.id.register);
        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        EditText edtemail=(EditText) findViewById(R.id.edttxtemail);
        EditText edtpass=(EditText) findViewById(R.id.txt_pass);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=edtemail.getText().toString().trim();
                pass=edtpass.getText().toString().trim();
                if(email.length()>0 && pass.length()>0){
                    DataClient dataClient= APIUtils.getData();
                    Call<List<Account>> callback=dataClient.Logindata(email,pass);
                    callback.enqueue(new Callback<List<Account>>() {
                        @Override
                        public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                            ArrayList<Account> accountsList= (ArrayList<Account>) response.body();

                            if(accountsList.size()>0){
                                Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                               // register.setText(accountsList.get(0).getName());
                                profile_static.setName(accountsList.get(0).getName());
                                profile_static.setPerr(accountsList.get(0).getPerr());
                                profile_static.setPhone(accountsList.get(0).getPhone());
                                profile_static.setGender(accountsList.get(0).getGender());
                                profile_static.setAddress(accountsList.get(0).getAddress());
                                profile_static.setPerr(accountsList.get(0).getPerr());
                                profile_static.setDob(accountsList.get(0).getDob());
                                profile_static.setImage(accountsList.get(0).getImage());
                                profile_static.setId(accountsList.get(0).getId());
                                id=(accountsList.get(0).getId());

                                Intent login = new Intent(Login.this, MainActivity.class);
                                Bundle bundle=new Bundle();
                                bundle.putSerializable("account",accountsList);
                                login.putExtra("login_data",bundle);
                                startActivity(login);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Account>> call, Throwable t) {
                            Toast.makeText(Login.this, "Tài khoảng không tồn tại", Toast.LENGTH_SHORT).show();
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

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Login.id = id;
    }
}