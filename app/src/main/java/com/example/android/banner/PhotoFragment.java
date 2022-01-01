package com.example.android.banner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.giasu.R;

public class PhotoFragment extends Fragment {

    private View mview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_photo, container, false);

        Bundle bundle = getArguments();
        Photo photo = (Photo) bundle.get("objet_photo");

        ImageView imgPhoto = mview.findViewById(R.id.img_photo);
        imgPhoto.setImageResource(photo.getResourceId());
        return mview;
    }
}
