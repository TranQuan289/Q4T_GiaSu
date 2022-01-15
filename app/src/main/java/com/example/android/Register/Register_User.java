package com.example.android.Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.Login;
import com.example.android.giasu.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_User extends AppCompatActivity {
    Button reg,back;
    String level;
    EditText edtphone,edtdob,edtgrnder,edtaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registeruser);
        reg = (Button) findViewById(R.id.btnreg);
        back= (Button) findViewById(R.id.btnback) ;

        edtphone=(EditText) findViewById(R.id.edttxtphone);
        edtdob=(EditText) findViewById(R.id.edttxtdate);
        edtgrnder=(EditText) findViewById(R.id.edttxtgender);
        edtaddress=(EditText) findViewById(R.id.edttxtaddress);
        Spinner edtlevel=(Spinner) findViewById(R.id.edttxtlevel);

        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("data");

        String name=bundle.getString("name");
        String email=bundle.getString("email");
        String pass=bundle.getString("pass");
        String perr=bundle.getString("perr");

        ArrayList<String> levelList=new ArrayList<>();
        levelList.add("1");
        levelList.add("2");
        levelList.add("3");
        levelList.add("4");
        levelList.add("5");
        levelList.add("6");
        levelList.add("7");
        levelList.add("8");
        levelList.add("9");
        levelList.add("10");
        levelList.add("11");
        levelList.add("12");
        ArrayAdapter monhocAdapter=new ArrayAdapter(Register_User.this,R.layout.support_simple_spinner_dropdown_item,levelList);
        monhocAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edtlevel.setAdapter(monhocAdapter);

        edtlevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                level=levelList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone=edtphone.getText().toString().trim();
                String dob=edtdob.getText().toString().trim();
                String gender=edtgrnder.getText().toString().trim();
                String address=edtaddress.getText().toString().trim();

                if(! (phone.equals("") || dob.equals("") || gender.equals("") || address.equals("") || level.equals(""))) {
                    DataClient register= APIUtils.getData();
                    Call<String> callback=register.Register(name,email,pass,address,gender,phone,dob,perr,level);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String result=response.body();
                            if(result.equals("success")){
                                Toast.makeText(Register_User.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                                Intent intent2=new Intent(Register_User.this,Login.class);
                                startActivity(intent2);
                            } else {
                                Toast.makeText(Register_User.this, "thất bại "+result, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(Register_User.this, "Xảy ra lỗi "+t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(Register_User.this, "Bạn chưa nhập đủ thông tin"+edtphone.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Register_User.this,Register.class);
                intent1.putExtra("databack",bundle);
                startActivity(intent1);
            }
        });
    }
}