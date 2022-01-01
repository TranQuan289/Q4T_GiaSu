package com.example.android.teacheruser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {
    View v;
    private RecyclerView rcvUser;
    private List<TeacherUser> mListUser;
    private TeacherUserAdapter userAdapter;
    public ListFragment() {
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list, container, false);
        rcvUser = v.findViewById(R.id.rcv_user);
        rcvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvUser.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        userAdapter = new TeacherUserAdapter(mListUser, new RecyclerViewClickInterface() {
            @Override
            public void onItemClick(TeacherUser user) {
                replaceFragment4(new TeacherUser2());
            }
        });
        userAdapter.setData(getmListUser());
        rcvUser.setAdapter(userAdapter);
        return v;
    }
    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment).addToBackStack(null).commit();
    }
    private List<TeacherUser> getmListUser(){
        List<TeacherUser> list = new ArrayList<>();
        list.add(new TeacherUser(R.drawable.avt, "Trần Anh Quân"));
        list.add(new TeacherUser(R.drawable.avt, "Trần Anh Quân"));
        list.add(new TeacherUser(R.drawable.avt, "Trần Anh Quân"));
        list.add(new TeacherUser(R.drawable.avt, "Trần Anh Quân"));
        list.add(new TeacherUser(R.drawable.avt, "Trần Anh Quân"));
        list.add(new TeacherUser(R.drawable.avt, "Trần Anh Quân"));
        return list;
    }
}
