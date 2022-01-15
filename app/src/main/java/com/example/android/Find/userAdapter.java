package com.example.android.Find;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.giasu.R;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.UserViewHolder>{
    private Context mcontext;
    private List<user>mlistUser;

    public userAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    public userAdapter(Fragment fragment) {
        this.mlistUser = (List<user>) fragment;
        notifyDataSetChanged();


    }

    public userAdapter(List<user> userList) {
        this.mlistUser = userList;
        notifyDataSetChanged();
    }

    public  void setData(List<user>list){
        this.mlistUser=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giasutheothanhpho,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        user User1 = mlistUser.get(position);
        if(User1 == null)
        {
            return;
        }
        holder.imgUser.setImageResource(R.drawable.avt);
        holder.txtname.setText(User1.getName());
        holder.txtkm.setText(User1.getFee());
        holder.txtloai.setText(User1.getPerr());
        holder.txtmon.setText(User1.getMon());
        holder.txtdiachi.setText(User1.getAddress());
    }

    @Override
    public int getItemCount() {
        if(mlistUser != null){
            return mlistUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgUser;
        private TextView txtname;
        private TextView txtkm;
        private TextView txtloai;
        private TextView txtmon;
        private TextView txtdiachi;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imgUser=itemView.findViewById(R.id.img_user);
            txtname=itemView.findViewById(R.id.txt_nameuser);
            txtkm=itemView.findViewById(R.id.txt_km);
            txtloai=itemView.findViewById(R.id.txt_loai);
            txtmon=itemView.findViewById(R.id.txt_mon);
            txtdiachi=itemView.findViewById(R.id.txt_address);
        }
    }
}
