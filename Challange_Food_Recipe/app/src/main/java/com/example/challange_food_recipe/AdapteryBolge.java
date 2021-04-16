package com.example.challange_food_recipe;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class AdapteryBolge  extends RecyclerView.Adapter<AdapteryBolge.MyViewHolder> {

    private Context mContext;
    private List<Bolge> mData;

    public AdapteryBolge(Context mContext, List<Bolge> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        v=layoutInflater.inflate(R.layout.bolge,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.strArea.setText(mData.get(position).getStrArea());
        holder.strArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bolge =mData.get(position).getStrArea();
                Intent intent = new Intent(mContext.getApplicationContext(), Food_list.class);
                intent.putExtra("veri",bolge.toString());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView strArea;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            strArea=itemView.findViewById(R.id.regText);
        }
    }
}
