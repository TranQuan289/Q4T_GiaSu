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

import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

public class TeacherClassFragment extends Fragment {
    private RecyclerView rcvlist;
    private List<TeacherClass> classList;
    private TeacherClassAdapter userAdapter;
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
        return v;
    }

    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment);
        transaction.commit();
    }
}
