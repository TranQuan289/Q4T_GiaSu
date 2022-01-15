package com.example.android.mess;

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
import com.example.android.giasu.R;
import com.example.android.teacheruser.TeacherUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class messFragment extends Fragment {
    private RecyclerView rcvlist;
    private List<mess> messList;
    private messAdapter messAdapter;
    private mess mess;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list3, container, false);
        rcvlist = v.findViewById(R.id.rcv_user);
        rcvlist.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvlist.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        messAdapter = new messAdapter(messList, new InterfaceMess() {
            @Override
            public void onItemClick(mess mess) {
                replaceFragment4(new MessFragment2());
            }
        });
        return v;
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }

    private void getMessAll() {
        DataClient dataClient = APIUtils.getData();
        Call<List<mess>> callback = dataClient.getAllMess();
        callback.enqueue(new Callback<List<mess>>() {
            @Override
            public void onResponse(Call<List<mess>> call, Response<List<mess>> response) {
                ArrayList<mess> listMess = (ArrayList<mess>) response.body();
                messAdapter = new messAdapter(listMess, mess);
                rcvlist.setAdapter(messAdapter);
            }

            @Override
            public void onFailure(Call<List<mess>> call, Throwable t) {

            }
        });
    }
}
