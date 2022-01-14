package com.example.android.giasu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.Account;
import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.profile_static;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class update_profile extends Fragment {

    EditText txtname,txtgender,txtaddress,txtdob,txtperr,txtphone ;
    Button btn_up;
    String id="1";
    ImageView img_back;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_update_profile, container, false);

        txtname =v.findViewById(R.id.txtname);
        txtgender =v.findViewById(R.id.txtgender);
        txtaddress = v.findViewById(R.id.txtaddress);
        txtdob = v.findViewById(R.id.txtdob);
        txtperr = v.findViewById(R.id.txtpeer);
        txtphone =v.findViewById(R.id.txtphone);
        img_back=v.findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_profile());
            }
        });

//        txtname.setText(profile_static.getName());
//        txtgender.setText(profile_static.getGender());
//        txtaddress.setText(profile_static.getAddress());
//        txtdob.setText(profile_static.getDob());
//        txtphone.setText(profile_static.getPhone());
//        txtperr.setText(profile_static.getPerr());

        btn_up =v.findViewById(R.id.btn_up);
        if(txtname.getText().toString().equals("") || txtgender.getText().toString().equals("")
            || txtaddress.getText().toString().equals("") || txtdob.getText().toString().equals("")
            || txtperr.getText().toString().equals("") || txtphone.getText().toString().equals(""))
        {
            Toast.makeText(getContext(), "Chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }
        else {
            btn_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DataClient dataClient = APIUtils.getData();
                    Call<String> callback = dataClient.update_profilr(
                            txtname.getText().toString().trim()
                            , txtperr.getText().toString().trim()
                            , txtphone.getText().toString().trim()
                            , txtgender.getText().toString().trim()
                            , txtaddress.getText().toString().trim()
                            , id
                            , txtdob.getText().toString().trim()

                    );
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String string = response.body().toString().trim();
                            if (string != null)
                                Toast.makeText(getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                }
            });
        }


//                enqueue(new Callback<List<Account>>() {
//            @Override
//            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
//                ArrayList<Account> accountsList= (ArrayList<Account>) response.body();
//
//
//
//                if(accountsList.size()>0){
//                    //Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                    // register.setText(accountsList.get(0).getName());
//                    profile_static.setName(accountsList.get(0).getName());
//                    profile_static.setPerr(accountsList.get(0).getPerr());
//                    profile_static.setPhone(accountsList.get(0).getPhone());
//                    profile_static.setGender(accountsList.get(0).getGender());
//                    profile_static.setAddress(accountsList.get(0).getAddress());
//                    profile_static.setPerr(accountsList.get(0).getPerr());
//                    profile_static.setDob(accountsList.get(0).getDob());
//                    profile_static.setImage(accountsList.get(0).getImage());
//                    profile_static.setId(accountsList.get(0).getId());
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Account>> call, Throwable t) {
//                //Toast.makeText(Login.this, "Tài khoảng không tồn tại", Toast.LENGTH_SHORT).show();
//            }
//        });



        return v;

    }
    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment).commit();
    }
}