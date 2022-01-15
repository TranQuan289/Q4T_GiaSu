package com.example.android.teacheruser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.Fragment_home;
import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTeacherSpotLightFragment extends Fragment {
    ImageButton imageButton;
    TextView txt_name, txt_level, txt_age, txt_gender, txt_address, txt_subject, txt_method;
    String name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_user2, container, false);
        imageButton = v.findViewById(R.id.back);
        txt_name = v.findViewById(R.id.txt_name);
        txt_level = v.findViewById(R.id.txt_level);
        txt_age = v.findViewById(R.id.txt_age);
        txt_gender = v.findViewById(R.id.txt_gender);
        txt_address = v.findViewById(R.id.txt_address);
        txt_subject = v.findViewById(R.id.txt_subject);
        txt_method = v.findViewById(R.id.txt_method);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_home());
            }
        });
        return v;
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }
    private void getDetailSpotLightList() {
        DataClient dataClient = APIUtils.getData();
        Call<List<DetailTeacherSpotLightClass>> callback = dataClient.getDetailTeacherSpotLight(name);
        callback.enqueue(new Callback<List<DetailTeacherSpotLightClass>>() {
            @Override
            public void onResponse(Call<List<DetailTeacherSpotLightClass>> call, Response<List<DetailTeacherSpotLightClass>> response) {

            }

            @Override
            public void onFailure(Call<List<DetailTeacherSpotLightClass>> call, Throwable t) {

            }
        });

    }
}
