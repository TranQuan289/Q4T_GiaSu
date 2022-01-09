package com.example.android.teacherclass;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.classlist.Fragment_manage;
import com.example.android.giasu.R;

public class DetailPostFragment extends Fragment{
    ImageView img_back;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_post,container,false);
        img_back = v.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_manage());
            }
        });
        return v;
    }
    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment);
        transaction.commit();
    }
}