package com.example.android.giasu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.Account;
import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.profile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profile_user extends Fragment {

    TextView upload,txtName,txtcv,phone,gioi,address,td,date;
    String url="http://192.168.1.7:8080/appGS/proflie.php";
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
        td = v.findViewById(R.id.td);
        date = v.findViewById(R.id.date);



        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Toast.makeText(getContext(),response.toString(),Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject object = response.getJSONObject(0);
                            txtName.setText(object.getString("email").toString());
                            txtcv.setText(object.getString("perr").toString());
                            if(txtcv.getText().toString().equals("0"))
                                txtcv.setText("Gia Sư");
                            else
                                gioi.setText("Học Sinh");
                            phone.setText(object.getString("phone").toString());
                            gioi.setText(object.getString("gender").toString());
                            if(gioi.getText().toString().equals("0"))
                                gioi.setText("Nam");
                            else
                                gioi.setText("Nữ");
                            address.setText(object.getString("address").toString());
                            td.setText(object.getString("perr").toString());
                            date.setText(object.getString("dob").toString());



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //accountArrayList
                    }
                },
                new com.android.volley.Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),"loikkkkkkkkkkk",Toast.LENGTH_SHORT).show();

                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

        return v;
    }

}