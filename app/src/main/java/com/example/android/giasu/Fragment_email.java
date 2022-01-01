package com.example.android.giasu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.giasu.R;
import com.example.android.mess.messFragment;
import com.example.android.teacherclass.TeacherClass2;

public class Fragment_email extends Fragment {
    View v;
    public Fragment_email() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_email,container,false);
        replaceFragment(new messFragment());
        return v;
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.constraintLayout,fragment).addToBackStack(null).commit();
        finishActivity();
    }
    private void finishActivity() {
        if(getActivity() != null) {
            getActivity().finish();
        }
    }
}
