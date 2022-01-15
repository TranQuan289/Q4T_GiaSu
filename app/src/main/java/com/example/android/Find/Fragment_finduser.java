package com.example.android.Find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_finduser extends Fragment {
    private RecyclerView rcvUser;
    private ArrayList<user> userList;
    private ImageView img_back;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_list,container,false);
        rcvUser=v.findViewById(R.id.rcv_user);
        img_back = v.findViewById(R.id.img_back);
        Bundle bundle=getArguments();

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_Find());
            }
        });
        rcvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvUser.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        userList = (ArrayList<user>) bundle.getSerializable("data");
        rcvUser.setAdapter(new userAdapter(userList));

        return v;

    }
    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }
}
