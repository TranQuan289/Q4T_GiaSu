package com.example.android.giasu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

public class profile_user extends Fragment {

    TextView upload,txtName,txtcv,phone,gioi,address,td,date,upload1,ic_class,class1;
    String url="http://192.168.1.7:8080/appGS/proflie.php";
    String id="3";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_profile_user, container, false);
        upload=v.findViewById(R.id.upload);
        txtName =v.findViewById(R.id.txtName);
        txtcv = v.findViewById(R.id.txtcv);
        phone = v.findViewById(R.id.phone);
        gioi= v.findViewById(R.id.gioi);
        address= v.findViewById(R.id.address);
        td = v.findViewById(R.id.level);
        date = v.findViewById(R.id.date);
        upload1=v.findViewById(R.id.upload2);
        ic_class =v.findViewById(R.id.ic_class);
        class1=v.findViewById(R.id.class1);

        txtName.setText(profile_static.getName());
        txtcv.setText(profile_static.getPerr());
        phone.setText(profile_static.getPhone());
        gioi.setText(profile_static.getGender());
        address.setText(profile_static.getAddress());
        td.setText(profile_static.getPerr());
        date.setText(profile_static.getDob());


        String i =td.getText().toString().trim();

        if(i.equals("1"))
        {
            ic_class.setCursorVisible(false);
            class1.setCursorVisible(false);
        }


        if(txtcv.getText().toString().equals("0"))
            txtcv.setText("Gia Sư");
        else
            txtcv.setText("Học Sinh");
        if(gioi.getText().toString().equals("0"))
            gioi.setText("Nam");
        else
            gioi.setText("Nữ");

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new update_profile());
            }
        });
        upload1.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {
                 replaceFragment4(new update_profile());
            }
        });
       //txtName.setText(profile.pro.getName());
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new com.android.volley.Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        // Toast.makeText(getContext(),response.toString(),Toast.LENGTH_SHORT).show();
//                        try {
//                            JSONObject object = response.getJSONObject(0);
//                            txtName.setText(object.getString("email").toString());
//                            txtcv.setText(object.getString("perr").toString());
//                            if(txtcv.getText().toString().equals("0"))
//                                txtcv.setText("Gia Sư");
//                            else
//                                gioi.setText("Học Sinh");
//                            phone.setText(object.getString("phone").toString());
//                            gioi.setText(object.getString("gender").toString());
//                            if(gioi.getText().toString().equals("0"))
//                                gioi.setText("Nam");
//                            else
//                                gioi.setText("Nữ");
//                            address.setText(object.getString("address").toString());
//                            td.setText(object.getString("perr").toString());
//                            date.setText(object.getString("dob").toString());
//
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        //accountArrayList
//                    }
//                },
//                new com.android.volley.Response.ErrorListener(){
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getContext(),"loikkkkkkkkkkk",Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//        );
//        requestQueue.add(jsonArrayRequest);

//        DataClient dataClient= APIUtils.getData();
//        Call<List<Account>> callback=dataClient.profile(id.trim());
//        callback.enqueue(new Callback<List<Account>>() {
//            @Override
//            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
//                ArrayList<Account> accountsList= (ArrayList<Account>) response.body();
//
//                txtName.setText(accountsList.get(0).getName().trim());
//
////                if(accountsList.size()>0){
////                    Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
////
////                    // register.setText(accountsList.get(0).getName());
////                    // profile.pro.setName(accountsList.get(0).getName());
////
////                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Account>> call, Throwable t) {
//                Toast.makeText(getContext(), "Tài khoảng không tồn tại", Toast.LENGTH_SHORT).show();
//            }
//
//            });


//            DataClient dataClient= APIUtils.getData();
//            Call<List<Account>> callback=dataClient.profile("3");
//            callback.enqueue(new Callback<List<Account>>() {
//                @Override
//                public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
//                    ArrayList<Account> accountsList1= (ArrayList<Account>) response.body();
//
//
//
//                    if(accountsList1.size()>0){
//                        Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                        txtName.setText(accountsList1.get(0).getName().trim());
//                        txtcv.setText(accountsList1.get(0).getPerr());
//                        if(txtcv.getText().toString().equals("0"))
//                            txtcv.setText("Gia Sư");
//                        else
//                            txtcv.setText("Học Sinh");
//                        phone.setText(accountsList1.get(0).getPhone());
//                        gioi.setText(accountsList1.get(0).getGender());
//                        if(gioi.getText().toString().equals("0"))
//                            gioi.setText("Nam");
//                        else
//                            gioi.setText("Nữ");
//                        address.setText(accountsList1.get(0).getAddress());
//                        td.setText(accountsList1.get(0).getPerr());
//                        date.setText(accountsList1.get(0).getDob());
//
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<List<Account>> call, Throwable t) {
//                    Toast.makeText(getContext(), "Tài khoảng không tồn tại", Toast.LENGTH_SHORT).show();
//                }
//            });
//
        return v;
    }
    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment).commit();
    }
}
