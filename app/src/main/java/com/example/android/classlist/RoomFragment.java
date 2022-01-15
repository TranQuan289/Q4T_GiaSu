package com.example.android.classlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.R;
import com.example.android.teacheruser.TeacherUser;
import com.example.android.teacheruser.TeacherUserAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomFragment extends Fragment {
    View v;
    private RecyclerView rcvRoom;
    private List<Room> roomList;
    private RoomAdapter roomAdapter;
    private Room room;
    public RoomFragment() {
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list,container,false);
        rcvRoom = v.findViewById(R.id.rcv_user);
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        getRoomList();
        return v;
    }
    private void getRoomList() {
        DataClient dataClient = APIUtils.getData();
        Call<List<Room>> callback = dataClient.getRoomList();
        callback.enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                ArrayList<Room> listRoom = (ArrayList<Room>) response.body();
                roomAdapter = new RoomAdapter(listRoom, room);
                rcvRoom.setAdapter(roomAdapter);
            }
            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
            }
        });
        }
}
