package com.example.android.teacheruser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.giasu.R;
import com.example.android.spotlightTeacher;

import java.util.List;

public class TeacherUserAdapter extends RecyclerView.Adapter<TeacherUserAdapter.UserViewHolder> {


    private  List<TeacherUser> mListUser;
    private RecyclerViewClickInterface clickInterface;
    private spotlightTeacher teacher;

    public TeacherUserAdapter(List<TeacherUser> mListUser,spotlightTeacher teacher ){
        this.mListUser = mListUser;
        this.teacher = teacher;
        notifyDataSetChanged();
    }
    public TeacherUserAdapter(List<TeacherUser> mListUser,RecyclerViewClickInterface clickInterface ){
        this.mListUser = mListUser;
        this.clickInterface = clickInterface;
        notifyDataSetChanged();
    }
    public void setData(List<TeacherUser> mListUser){
        this.mListUser = mListUser;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacheruser, parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder,int position) {
       final TeacherUser user = mListUser.get(position);
        if(user == null){
            return;
        }
        holder.tvname.setText(user.getName());
        holder.imAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInterface.onItemClick(user);
            }
        });
    }
    @Override
    public int getItemCount() {
        if(mListUser!= null){
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout imAvatar;
        private TextView tvname;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imAvatar = itemView.findViewById(R.id.layout_item);
            tvname = itemView.findViewById(R.id.txtname);
        }
    }

}
