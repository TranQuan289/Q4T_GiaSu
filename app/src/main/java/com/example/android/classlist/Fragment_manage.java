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
import com.example.android.teacherclass.DetailPostFragment;

import java.util.ArrayList;
import java.util.List;

public class Fragment_manage extends Fragment {
    private RecyclerView rcvRoom;
    private List<Room> roomList;
    private ManageAdapter roomAdapter;

    public Fragment_manage() {
    }

    ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manage, container, false);
        ImageView img_back = v.findViewById(R.id.img_back);
        rcvRoom = v.findViewById(R.id.rcv_users);
        roomAdapter = new ManageAdapter(roomList, new interfaceListPost() {
            @Override
            public void onItemClick(Room room) {
                replaceFragment4(new DetailPostFragment());
            }
        });
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        roomAdapter.setData(getListRoom());
        rcvRoom.setAdapter(roomAdapter);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_profile());
            }
        });
        return v;
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }

    private List<Room> getListRoom() {
        List<Room> list = new ArrayList<>();
        return list;
    }
}
