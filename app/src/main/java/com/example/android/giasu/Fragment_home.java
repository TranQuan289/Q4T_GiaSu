package com.example.android.giasu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.android.Find.Fragment_Find;
import com.example.android.banner.Photo;
import com.example.android.banner.PhotoAdapter;
import com.example.android.classlist.RoomFragment;
import com.example.android.classlist1.RoomFragment1;
import com.example.android.teacherclass.TeacherClassFragment;
import com.example.android.teacherclass.TeacherClassFragment1;
import com.example.android.teacheruser.ListFragment;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class Fragment_home extends Fragment {
    View v;
    private TextView mviewall,mviewall1;
    private ViewPager2 mViewPager2;
    private ImageView img;
    private CircleIndicator3 mCircleIndicator3;
    private List<Photo> mListPhoto;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            int current = mViewPager2.getCurrentItem();
            if(current == mListPhoto.size() - 1 ){
                mViewPager2.setCurrentItem(0);
            }else {
                mViewPager2.setCurrentItem(current + 1);
            }
        }
        };
    public Fragment_home() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v = inflater.inflate(R.layout.activity_home,container,false);
        mviewall = v.findViewById(R.id.txtviewall);
        mviewall1 = v.findViewById(R.id.txtviewall1);
        img = v.findViewById(R.id.img1);
        mviewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new TeacherClassFragment1());
            }
        });
        mviewall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new RoomFragment1());
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_Find());
            }
        });
        replaceFragment(new ListFragment());
        replaceFragment2(new RoomFragment());
        replaceFragment3(new TeacherClassFragment());
        mViewPager2 = v.findViewById(R.id.view_pager_2);
        mCircleIndicator3 = v.findViewById(R.id.circle_indicator_3);
        mListPhoto = getListPhoto();
        PhotoAdapter photoAdapter = new PhotoAdapter(this, mListPhoto);
        mViewPager2.setAdapter(photoAdapter);
        mCircleIndicator3.setViewPager(mViewPager2);
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable, 3000);
            }});

        return v;

    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.rcv_user1,fragment).commit();
    //        transaction.replace(R.id.rcv_user3,fragment);
    }
    private void replaceFragment2(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        //transaction.replace(R.id.rcv_user1,fragment);
        transaction.replace(R.id.rcv_user2,fragment).commit();
        //        transaction.replace(R.id.rcv_user3,fragment);
    }
    private void replaceFragment3(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        //transaction.replace(R.id.rcv_user1,fragment);
        transaction.replace(R.id.rcv_user3,fragment).commit();
    }
    private void replaceFragment4(Fragment fragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        //transaction.replace(R.id.rcv_user1,fragment);
        transaction.replace(R.id.main,fragment).addToBackStack(null).commit();
    }

    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.banner1));
        list.add(new Photo(R.drawable.banner2));
        list.add(new Photo(R.drawable.banner3));
        return list;
    }

    @Override
    public void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable,3000);
    }

}
