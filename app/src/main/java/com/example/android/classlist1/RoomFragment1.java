package com.example.android.classlist1;

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

import com.example.android.giasu.Fragment_home;
import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

public class RoomFragment1 extends Fragment {
    View v;
    private RecyclerView rcvRoom1;
    private List<Room1> roomList1;
    private ImageView img;

    public RoomFragment1() {
    }

    ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list2, container, false);
        rcvRoom1 = v.findViewById(R.id.rcv_user);
        img = v.findViewById(R.id.img);
        rcvRoom1.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvRoom1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        roomList1 = new ArrayList<>();
        Room1 ob1 = new Room1("Lớp : 7", "Môn : Toán", "Học phí : 30k/1h", R.drawable.ic_localblack, "Hải Châu", "Hình thức dạy: online");
        roomList1.add(ob1);
        Room1 ob2 = new Room1("Lớp : 7", "Môn : Toán", "Học phí : 30k/1h", R.drawable.ic_localblack, "Hải Châu", "Hình thức dạy: online");
        roomList1.add(ob2);
        Room1 ob3 = new Room1("Lớp : 7", "Môn : Toán", "Học phí : 30k/1h", R.drawable.ic_localblack, "Hải Châu", "Hình thức dạy: online");
        roomList1.add(ob3);
        Room1 ob4 = new Room1("Lớp : 7", "Môn : Toán", "Học phí : 30k/1h", R.drawable.ic_localblack, "Hải Châu", "Hình thức dạy: online");
        roomList1.add(ob4);
        Room1 ob5 = new Room1("Lớp : 7", "Môn : Toán", "Học phí : 30k/1h", R.drawable.ic_localblack, "Hải Châu", "Hình thức dạy: online");
        roomList1.add(ob5);
        Room1 ob6 = new Room1("Lớp : 7", "Môn : Toán", "Học phí : 30k/1h", R.drawable.ic_localblack, "Hải Châu", "Hình thức dạy: online");
        roomList1.add(ob6);
        rcvRoom1.setAdapter(new RoomAdapter1(roomList1));
        img.setOnClickListener(new View.OnClickListener() {
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
}
