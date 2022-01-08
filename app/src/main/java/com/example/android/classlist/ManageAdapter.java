package com.example.android.classlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.giasu.R;

import java.util.List;

public class ManageAdapter extends RecyclerView.Adapter<ManageAdapter.UserViewHolder> {
    private List<Room> mListRoom;


    public ManageAdapter(List<Room> mListRoom){
        this.mListRoom = mListRoom;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Room room  = mListRoom.get(position);
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
        if(mListRoom!= null){
            return mListRoom.size();
        }
        return 0;
    }

    public class    UserViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView tvname,tvsubject,tvmoney,tvarea,tvonline;

        public UserViewHolder(@NonNull View itemView) {
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