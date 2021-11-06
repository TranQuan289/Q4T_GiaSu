package com.example.android.teacherclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.giasu.R;
import com.example.android.teacheruser.TeacherUser;
import com.example.android.teacheruser.TeacherUserAdapter;

import java.util.List;

public class TeacherClassAdapter extends RecyclerView.Adapter<TeacherClassAdapter.UserViewHolder>{

    private List<TeacherClass> classList;
    private InterfaceListUser interfaceListUser;

    public TeacherClassAdapter(List<TeacherClass> classList, InterfaceListUser interfaceListUser) {
        this.classList = classList;
        this.interfaceListUser = interfaceListUser;
        notifyDataSetChanged();
    }
    public void setData(List<TeacherClass> classList){
        this.classList = classList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacherlist, parent,false);
        return new TeacherClassAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final TeacherClass teacherClass = classList.get(position);
        if (teacherClass == null) {
            return;
        }
        holder.img1.setImageResource(teacherClass.getResourceId());
        holder.img2.setImageResource(teacherClass.getLocal());
        holder.tvname.setText(teacherClass.getName());
        holder.tvnameclass.setText(teacherClass.getNameclass());
        holder.tvsubject.setText(teacherClass.getSubject());
        holder.tvaddress.setText(teacherClass.getAddress());
        holder.tvonline.setText(teacherClass.getOnline());
        holder.rlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceListUser.onItemClick(teacherClass);
            }
        });
    }
    @Override
    public int getItemCount() {
        if(classList !=null){
            return classList.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView img1, img2;
        private TextView tvnameclass, tvsubject, tvname, tvaddress, tvonline;
        private RelativeLayout rlt;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img_avt3);
            tvnameclass = itemView.findViewById(R.id.txtclass3);
            tvname = itemView.findViewById(R.id.txtname3);
            tvsubject = itemView.findViewById(R.id.txtsubject3);
            img2 = itemView.findViewById(R.id.img3);
            tvaddress = itemView.findViewById(R.id.txtaddress3);
            tvonline = itemView.findViewById(R.id.txtonline3);
            rlt = itemView.findViewById(R.id.rlt);
        }
    }
}

