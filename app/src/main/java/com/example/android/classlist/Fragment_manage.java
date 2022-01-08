package com.example.android.classlist;

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

import com.example.android.giasu.Fragment_profile;
import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_manage extends Fragment {
    private RecyclerView rcvRoom;
    private List<Room> roomList;
    public Fragment_manage() {
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manage,container,false);
        ImageView img_back = v.findViewById(R.id.img_back);
        rcvRoom = v.findViewById(R.id.rcv_users);
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        roomList = new ArrayList<>();
        Room ob1= new Room("Lớp : 8","Môn : Toán Học","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu, Đà Nẵng","Hình thức dạy: online");
        Room ob2= new Room("Lớp : 8","Môn : Toán Học","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu, Đà Nẵng","Hình thức dạy: online");
        Room ob3= new Room("Lớp : 8","Môn : Toán Học","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu, Đà Nẵng","Hình thức dạy: online");
        Room ob4= new Room("Lớp : 8","Môn : Toán Học","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu, Đà Nẵng","Hình thức dạy: online");
        Room ob5= new Room("Lớp : 8","Môn : Toán Học","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu, Đà Nẵng","Hình thức dạy: online");
        Room ob6= new Room("Lớp : 8","Môn : Toán Học","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu, Đà Nẵng","Hình thức dạy: online");
        roomList.add(ob1);
        roomList.add(ob2);
        roomList.add(ob3);
        roomList.add(ob4);
        roomList.add(ob5);
        roomList.add(ob6);
        rcvRoom.setAdapter(new ManageAdapter(roomList));
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_profile());
            }
        });
        return v;
    }
    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment).addToBackStack(null).commit();
    }
}
