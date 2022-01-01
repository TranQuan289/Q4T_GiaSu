package com.example.android.classlist;

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

public class RoomFragment extends Fragment {
    View v;
    private RecyclerView rcvRoom;
    private List<Room> roomList;
    public RoomFragment() {
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list,container,false);
        rcvRoom = v.findViewById(R.id.rcv_user);
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        roomList = new ArrayList<>();
        Room ob1= new Room("Lớp : 7","Môn : Toán","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu","Hình thức dạy: online");
        roomList.add(ob1);
        Room ob2= new Room("Lớp : 7","Môn : Toán","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu","Hình thức dạy: online");
        roomList.add(ob2);
        Room ob3= new Room("Lớp : 7","Môn : Toán","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu","Hình thức dạy: online");
        roomList.add(ob3);
        Room ob4= new Room("Lớp : 7","Môn : Toán","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu","Hình thức dạy: online");
        roomList.add(ob4);
        Room ob5= new Room("Lớp : 7","Môn : Toán","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu","Hình thức dạy: online");
        roomList.add(ob5);
        Room ob6= new Room("Lớp : 7","Môn : Toán","Học phí : 30k/1h", R.drawable.ic_local,"Hải Châu","Hình thức dạy: online");
        roomList.add(ob6);
        rcvRoom.setAdapter(new RoomAdapter(roomList));
        return v;
    }
}
