package com.example.android.Find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_finduser extends Fragment {
    private RecyclerView rcvUser;
    private List<user> userList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_list,container,false);
        rcvUser=v.findViewById(R.id.rcv_user);
        rcvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvUser.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        userList = new ArrayList<>();
        user ob1 = new user(R.drawable.avt,"Elonmussk","3.05km","Xuất sắc","Toán, lý","Đà Nẵng");
        userList.add(ob1);
        user ob2 = new user(R.drawable.avt,"Elonmussk","3.05km","Xuất sắc","Toán, lý","Đà Nẵng");
        userList.add(ob2);
        user ob3 = new user(R.drawable.avt,"Elonmussk","3.05km","Xuất sắc","Toán, lý","Đà Nẵng");
        userList.add(ob3);
        user ob4 = new user(R.drawable.avt,"Elonmussk","3.05km","Xuất sắc","Toán, lý","Đà Nẵng");
        userList.add(ob4);
        user ob5 = new user(R.drawable.avt,"Elonmussk","3.05km","Xuất sắc","Toán, lý","Đà Nẵng");
        userList.add(ob5);
        rcvUser.setAdapter(new userAdapter(userList));


        return v;

    }
    
}
