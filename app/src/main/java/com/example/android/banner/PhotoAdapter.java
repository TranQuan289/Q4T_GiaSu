package com.example.android.banner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.android.giasu.Fragment_home;

import java.util.List;

public class PhotoAdapter extends FragmentStateAdapter {

    private List<Photo> mlistPhoto;

    public PhotoAdapter(@NonNull Fragment_home fragmentActivity, List<Photo> list) {
        super(fragmentActivity);
        this.mlistPhoto = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Photo photo = mlistPhoto.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("objet_photo", photo);

        PhotoFragment photoFragment = new PhotoFragment();
        photoFragment.setArguments(bundle);

        return photoFragment;
    }

    @Override
    public int getItemCount() {
        if(mlistPhoto != null){
            return mlistPhoto.size();
        }
        return 0;
    }
}
