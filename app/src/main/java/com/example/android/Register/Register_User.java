package com.example.android.Register;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.Login;
import com.example.android.giasu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_User extends AppCompatActivity {
    Button reg, back;
    EditText edtphone, edtdob, edtgrnder, edtaddress, edtlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registeruser);
        reg = (Button) findViewById(R.id.btnreg);
        back = (Button) findViewById(R.id.btnback);

        edtphone = (EditText) findViewById(R.id.edttxtphone);
        edtdob = (EditText) findViewById(R.id.edttxtdate);
        edtgrnder = (EditText) findViewById(R.id.edttxtgender);
        edtaddress = (EditText) findViewById(R.id.edttxtaddress);
        edtlevel = (EditText) findViewById(R.id.edttxtlevel);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");

        String name = bundle.getString("name");
        String email = bundle.getString("email");
        String pass = bundle.getString("pass");
        String perr = bundle.getString("perr");


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = edtphone.getText().toString().trim();
                String dob = edtdob.getText().toString().trim();
                String gender = edtgrnder.getText().toString().trim();
                String address = edtaddress.getText().toString().trim();
                String level = edtlevel.getText().toString().trim();

                if (!(phone.equals("") || dob.equals("") || gender.equals("") || address.equals("") || level.equals(""))) {
                    DataClient register = APIUtils.getData();
                    Call<String> callback = register.Register(name, email, pass, address, gender, phone, dob, perr, level);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String result = response.body();
                            if (result.equals("success")) {
                                openDialog(Gravity.BOTTOM);
                                Intent intent2 = new Intent(Register_User.this, Login.class);
                                startActivity(intent2);
                            } else {
                                Toast.makeText(Register_User.this, "thất bại " + result, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(Register_User.this, "Xảy ra lỗi " + t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(Register_User.this, "Bạn chưa nhập đủ thông tin" + edtphone.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Register_User.this, Register.class);
                intent1.putExtra("databack", bundle);
                startActivity(intent1);
            }
        });
    }

    private void openDialog(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_register);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }
        dialog.show();
    }
}