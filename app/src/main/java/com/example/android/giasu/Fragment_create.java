package com.example.android.giasu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.android.create.CreateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Fragment_create extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_create,container,false);
        tabLayout= v.findViewById(R.id.tab_layout);
        viewPager2= v.findViewById(R.id.view_paperr);

        final CreateAdapter adapter=new CreateAdapter(this);
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Gia Sư");
                    break;
                case 1:
                    tab.setText("Người dùng");
                    break;
            }
        }).attach();
        return v;
    }
}
