package com.example.android.Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.giasu.R;

public class Register extends AppCompatActivity {
    Button button;
    RadioButton radioButton1, radioButton2;
    EditText edtname, edtemail, edtpass, edtcppass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        Button button = (Button) findViewById(R.id.btnnext);
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rb2);
        edtname = (EditText) findViewById(R.id.edttxtname);
        edtemail = (EditText) findViewById(R.id.edttxtemail);
        edtpass = (EditText) findViewById(R.id.edttxtpass1);
        edtcppass = (EditText) findViewById(R.id.edttxtpass2);

        Intent intent1 = getIntent();
        Bundle bundle1 = intent1.getBundleExtra("databack");
        if (bundle1 != null) {
            edtname.setText(bundle1.getString("name"));
            edtemail.setText(bundle1.getString("email"));
            edtpass.setText(bundle1.getString("pass"));
            edtcppass.setText(bundle1.getString("pass"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = edtpass.getText().toString().trim();
                String pass1 = edtcppass.getText().toString().trim();
                String name = edtname.getText().toString().trim();
                String email = edtemail.getText().toString().trim();
                if (!(name.equals("") || email.equals("") || pass.equals("") || pass1.equals(""))) {
                    if (pass.equals(pass1)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name);
                        bundle.putString("email", email);
                        bundle.putString("pass", pass);
                        if (radioButton1.isChecked()) {
                            Intent dkgs = new Intent(Register.this, Register_Teacher.class);
                            bundle.putString("perr", "1");
                            dkgs.putExtra("data", bundle);
                            startActivity(dkgs);
                        } else if (radioButton2.isChecked()) {
                            Intent dkhs = new Intent(Register.this, Register_User.class);
                            bundle.putString("perr", "0");
                            dkhs.putExtra("data", bundle);
                            startActivity(dkhs);
                        } else {
                            Toast.makeText(getApplicationContext(), "Vui lòng chọn?", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(Register.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Register.this, "Bạn chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}