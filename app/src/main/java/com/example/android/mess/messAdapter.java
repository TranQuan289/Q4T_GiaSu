package com.example.android.mess;

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

public class messAdapter extends RecyclerView.Adapter<messAdapter.messViewHolder> {
    private List<mess> messList;
    private InterfaceMess interfaceMess;

    public messAdapter(List<mess> messList,InterfaceMess interfaceMess){
        this.messList = messList;
        this.interfaceMess = interfaceMess;
        notifyDataSetChanged();
    }
    public void setData(List<mess> messList){
        this.messList = messList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public messViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mess, parent,false);
        return new messViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull messViewHolder holder, int position) {
        final mess mess = messList.get(position);
            holder.img1.setImageResource(mess.getImg1());
            holder.img2.setImageResource(mess.getImg2());
            holder.txt1.setText(mess.getName());
            holder.txt2.setText(mess.getContent());
            holder.rlt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interfaceMess.onItemClick(mess);
                }
            });
    }

    @Override
    public int getItemCount() {
        if(messList !=null){
            return messList.size();
        }
        return 0;
    }

    public class messViewHolder extends RecyclerView.ViewHolder{
            ImageView img1,img2;
            TextView txt1,txt2;
            RelativeLayout rlt;
        public messViewHolder(@NonNull View view) {
            super(view);
            img1 = view.findViewById(R.id.mess_image);
            img2 = view.findViewById(R.id.seen);
            txt1 = view.findViewById(R.id.txtName);
            txt2 = view.findViewById(R.id.txtContent);
            rlt = view.findViewById(R.id.rltl);
        }
    }
}
