package com.example.challange_food_recipe;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapteryCategories extends RecyclerView.Adapter<AdapteryCategories.MyViewHolder>{
    private Context mContext;
    private List<Categories> mData;

    public AdapteryCategories(Context mContext, List<Categories> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater infalter= LayoutInflater.from(mContext);
        v=infalter.inflate(R.layout.food_list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.strCategory.setText(mData.get(position).getStrCategory());

        Glide.with(mContext)
                .load(mData.get(position).getStrCategoryThumb())
                .into(holder.strCategoryThumb);

        holder.strCategoryThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category =mData.get(position).getStrCategory();
                Intent intent = new Intent(mContext.getApplicationContext(), Food_list.class);
                intent.putExtra("category",category.toString());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView strCategory;
        ImageView strCategoryThumb;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            strCategory=itemView.findViewById(R.id.foodlistname);
            strCategoryThumb=itemView.findViewById(R.id.foodlistimg);
        }
    }
}
