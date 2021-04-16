package com.example.challange_food_recipe;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.util.Collections;
import java.util.List;

public class AdapteryFoodList extends RecyclerView.Adapter<AdapteryFoodList.MyViewHolder>{
    private Context mContext;
    private List<BolgeFoodList> mData;


    public AdapteryFoodList(Context mContext, List<BolgeFoodList> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater infalter= LayoutInflater.from(mContext);
        v=infalter.inflate(R.layout.food_list,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.strMeal.setText(mData.get(position).getStrMeal());

        Glide.with(mContext)
                .load(mData.get(position).getStrMealThumb())
                .into(holder.strMealThumb);

        holder.strMealThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id =mData.get(position).getIdMeal();
                Intent intent = new Intent(mContext.getApplicationContext(), Food_main.class);
                intent.putExtra("id",id.toString());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView strMeal;
        ImageView strMealThumb;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            strMeal=itemView.findViewById(R.id.foodlistname);
            strMealThumb=itemView.findViewById(R.id.foodlistimg);



        }
    }
}
