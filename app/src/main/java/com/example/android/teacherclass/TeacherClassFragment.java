package com.example.android.teacherclass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.classlist1.Room1;
import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherClassFragment extends Fragment {
    private RecyclerView rcvlist;
    private List<TeacherClass> classList;
    private TeacherClassAdapter userAdapter;
    private TeacherClass teacherClass;
    public TeacherClassFragment(){
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list,container,false);
        rcvlist = v.findViewById(R.id.rcv_user);
        rcvlist.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        userAdapter = new TeacherClassAdapter(classList, new InterfaceListUser() {
            @Override
            public void onItemClick(TeacherClass teacherClass) {
                replaceFragment4(new TeacherClass2());
            }
        });
        getTeacherClass();
        return v;
    }

    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment);
        transaction.commit();
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
