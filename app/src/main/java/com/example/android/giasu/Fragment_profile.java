package com.example.android.giasu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.Account;
import com.example.android.Register.ChangePassFragment;
import com.example.android.classlist.Fragment_manage;


import java.util.List;

public class Fragment_profile extends Fragment {
    TextView logout, profile,txt_manage,txt_changepass,txtname,txtcv;
    RelativeLayout relativeLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_profile, container, false);
        txt_changepass = v.findViewById(R.id.txt_changepass);
        logout = (TextView) v.findViewById(R.id.textlogout);
        profile = (TextView) v.findViewById(R.id.txtProfile);
        txt_manage = v.findViewById(R.id.txt_manage);
        txtname =v.findViewById(R.id.txt_name);
        txtcv = v.findViewById(R.id.textView14);



        relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);

        List<Account> accounts = (List<Account>) getArguments().get("account");
        txtname.setText(accounts.get(0).getName());
        if(accounts.get(0).getPerr().equals("0"))
            txtcv.setText("Gia Sư");
        else
            txtcv.setText("Học Sinh");

        //Toast.makeText(getContext(), accounts.get(0).getName(), Toast.LENGTH_SHORT).show();



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });
        txt_manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment4(new Fragment_manage());
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment4(new profile_user());
            }
        });
        txt_changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment4(new ChangePassFragment());
            }
        });
        return v;


    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }
}
