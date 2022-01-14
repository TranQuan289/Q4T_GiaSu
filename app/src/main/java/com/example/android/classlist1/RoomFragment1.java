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

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.classlist.Room;
import com.example.android.classlist.RoomAdapter;
import com.example.android.giasu.Fragment_home;
import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomFragment1 extends Fragment {
    View v;
    private RecyclerView rcvRoom1;
    private List<Room1> roomList1;
    private ImageView img_back;
    private RoomAdapter1 roomAdapter1;
    private Room1 room1;

    public RoomFragment1() {
    }

    ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_listroomall, container, false);
        rcvRoom1 = v.findViewById(R.id.rcv_user);
        img_back = v.findViewById(R.id.img_back);
        rcvRoom1.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvRoom1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_home());

            }
        });
        getRoomList();
        return v;
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }
    private void getRoomList() {
        DataClient dataClient = APIUtils.getData();
        Call<List<Room1>> callback = dataClient.getRoomList1();
        callback.enqueue(new Callback<List<Room1>>() {
            @Override
            public void onResponse(Call<List<Room1>> call, Response<List<Room1>> response) {
                ArrayList<Room1> listRoom1 = (ArrayList<Room1>) response.body();
                roomAdapter1 = new RoomAdapter1(listRoom1,room1);
                rcvRoom1.setAdapter(roomAdapter1);
            }

            @Override
            public void onFailure(Call<List<Room1>> call, Throwable t) {

            }
        });
    }
}
