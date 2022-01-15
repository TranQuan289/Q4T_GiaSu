package com.example.android.teacherclass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.Fragment_home;
import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherClassFragment1 extends Fragment {
    private RecyclerView rcvlist;
    private List<TeacherClass> classList;
    private TeacherClassAdapter userAdapter;
    ImageView img_back;
    private TeacherClass teacherClass;
    public  TeacherClassFragment1(){
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listteacherall,container,false);
        rcvlist = v.findViewById(R.id.rcv_user);
        img_back = v.findViewById(R.id.img_back);
        rcvlist.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        userAdapter = new TeacherClassAdapter(classList, new InterfaceListUser() {
            @Override
            public void onItemClick(TeacherClass teacherClass) {
                replaceFragment4(new TeacherClass2());
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_home());
            }
        });
        getTeacherClass();
        return v;
    }

    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment).addToBackStack(null).commit();
    }
    private void getTeacherClass(){
        DataClient dataClient = APIUtils.getData();
        Call<List<TeacherClass>> callback = dataClient.getTeacherClass();
        callback.enqueue(new Callback<List<TeacherClass>>() {
            @Override
            public void onResponse(Call<List<TeacherClass>> call, Response<List<TeacherClass>> response) {
                ArrayList<TeacherClass> TeacherClass = (ArrayList<TeacherClass>) response.body();
                userAdapter = new TeacherClassAdapter(TeacherClass,teacherClass);
                rcvlist.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<TeacherClass>> call, Throwable t) {

            }
        });
    }
}