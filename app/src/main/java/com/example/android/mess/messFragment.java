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

import com.example.android.giasu.R;

import java.util.ArrayList;
import java.util.List;

public class messFragment extends Fragment {
    private RecyclerView rcvlist;
    private List<mess> messList;
    private messAdapter messAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_list3,container,false);
        rcvlist = v.findViewById(R.id.rcv_user);
        rcvlist.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
       messAdapter = new messAdapter(messList, new InterfaceMess() {
           @Override
           public void onItemClick(mess mess) {
               replaceFragment4(new MessFragment2());
           }
       });
       messAdapter.setData(getMessList());
       rcvlist.setAdapter(messAdapter);
        return v;
    }
    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment).addToBackStack(null).commit();
    }
    private List<mess> getMessList(){
        List<mess> list = new ArrayList<>();
        list.add(new mess(R.drawable.avt,"Phan Thiện","Không học thôi anh không ép", R.drawable.ic_check));
        list.add(new mess(R.drawable.avt,"Phan Thiện","Không học thôi anh không ép", R.drawable.ic_check));
        list.add(new mess(R.drawable.avt,"Phan Thiện","Không học thôi anh không ép", R.drawable.ic_check));
        list.add(new mess(R.drawable.avt,"Phan Thiện","Không học thôi anh không ép", R.drawable.ic_check));
        list.add(new mess(R.drawable.avt,"Phan Thiện","Không học thôi anh không ép", R.drawable.ic_check));
        list.add(new mess(R.drawable.avt,"Phan Thiện","Không học thôi anh không ép", R.drawable.ic_check));
        list.add(new mess(R.drawable.avt,"Phan Thiện","Không học thôi anh không ép", R.drawable.ic_check));
        return list;
    }
}
