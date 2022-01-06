package com.example.android.create;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CreateAdapter extends FragmentStateAdapter {


    public CreateAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CreateTeacherFragment();
            case 1:
                return new CreateUserFragment();
            default:
                return null;
        }
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
