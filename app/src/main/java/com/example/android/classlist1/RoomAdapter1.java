package com.example.android.classlist1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.giasu.R;

import java.util.List;

public class RoomAdapter1 extends RecyclerView.Adapter<RoomAdapter1.UserViewHolder1> {
    private List<Room1> mListRoom1;


    public RoomAdapter1(List<Room1> mListRoom1) {
        this.mListRoom1 = mListRoom1;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_classlist, parent,false);
        return new UserViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder1 holder, int position) {
        Room1 room  = mListRoom1.get(position);
        if(room == null){
            return;
        }

        holder.tvname.setText(room.getNameclass());
        holder.tvsubject.setText(room.getSubject());
        holder.tvmoney.setText(room.getMoney());
        holder.img.setImageResource(room.getResourceId());
        holder.tvarea.setText(room.getArea());
        holder.tvonline.setText(room.getOnline());
    }


    @Override
    public int getItemCount() {
        if(mListRoom1!= null){
            return mListRoom1.size();
        }
        return 0;
    }

    public class UserViewHolder1 extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView tvname,tvsubject,tvmoney,tvarea,tvonline;

        public UserViewHolder1(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvname = itemView.findViewById(R.id.txtnameclass);
            tvsubject = itemView.findViewById(R.id.txtsubject);
            tvmoney = itemView.findViewById(R.id.txtmoney);
            tvarea = itemView.findViewById(R.id.txtarea);
            tvonline = itemView.findViewById(R.id.txtonline);
        }
    }
}