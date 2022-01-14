package com.example.android.Find;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.android.create.CreateUserFragment;

public class FindAdapter extends FragmentStatePagerAdapter {
    public FindAdapter(FragmentManager fragmentManager, Fragment_Find fragment_find, int tabCount) {
    super(fragmentManager);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0 :
                title = "Tìm kiếm theo từ khóa";
                break;
            case 1:
                title = "Tìm kiếm quanh đây";
                break;
        }
        return title;
    }
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FindCity();
            case 1:
                return new FindMap();
            default:
                return new CreateUserFragment();
        }
    }
    @Override
    public int getCount() {
        return 2;
    }

}
