package com.example.android.giasu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_profile extends Fragment {
    TextView logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_profile,container,false);
        logout = v.findViewById(R.id.txt_proflie);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_profile2());
            }
        });

        return v;
    }
    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.main,fragment).addToBackStack(null).commit();
        finishActivity();
    }
    private void finishActivity() {
        if(getActivity() != null) {
            getActivity().finish();
        }
    }
}
