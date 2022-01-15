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

import java.util.List;

public class TeacherClassAdapter extends RecyclerView.Adapter<TeacherClassAdapter.UserViewHolder>{

    private List<TeacherClass> classList;
    private InterfaceListUser interfaceListUser;
    private TeacherClass teacherClass;

    public TeacherClassAdapter(List<TeacherClass> classList, InterfaceListUser interfaceListUser) {
        this.classList = classList;
        this.interfaceListUser = interfaceListUser;
        notifyDataSetChanged();
    }
    public TeacherClassAdapter(List<TeacherClass> classList, TeacherClass teacherClass) {
        this.classList = classList;
        this.teacherClass = teacherClass;
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
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final TeacherClass teacherClass = classList.get(position);
        if (teacherClass == null) {
            return;
        }
        holder.tvname.setText(teacherClass.getName());
        holder.tvnameclass.setText(teacherClass.getGrade());
        holder.tvsubject.setText(teacherClass.getSubject());
        holder.tvaddress.setText(teacherClass.getAddress());
        holder.tvonline.setText(teacherClass.getMethod());
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
        private TextView tvnameclass, tvsubject, tvname, tvaddress, tvonline;
        private RelativeLayout rlt;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnameclass = itemView.findViewById(R.id.txtclass3);
            tvname = itemView.findViewById(R.id.txtname3);
            tvsubject = itemView.findViewById(R.id.txtsubject3);
            tvaddress = itemView.findViewById(R.id.txtaddress3);
            tvonline = itemView.findViewById(R.id.txtonline3);
            rlt = itemView.findViewById(R.id.rlt);
        }
    }
}

