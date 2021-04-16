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

public class AdapteryFood extends RecyclerView.Adapter<AdapteryFood.MyViewHolder> {

    private Context mContext;
    private List<Food> mData;

    public AdapteryFood(Context mContext, List<Food> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public AdapteryFood.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        v=layoutInflater.inflate(R.layout.food_main,parent,false);
        return new AdapteryFood.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapteryFood.MyViewHolder holder, int position) {

        holder.strArea.setText(mData.get(position).getStrArea());
        holder.strMeal.setText(mData.get(position).getStrMeal());
        holder.strCategory.setText(mData.get(position).getStrCategory());
        holder.strDrinkAlternate.setText(mData.get(position).getStrDrinkAlternate());
        holder.strInstructions.setText(mData.get(position).getStrInstructions());



        holder.strIngredient1.setText(mData.get(position).getStrIngredient1());
        holder.strIngredient2.setText(mData.get(position).getStrIngredient2());
        holder.strIngredient3.setText(mData.get(position).getStrIngredient3());
        holder.strIngredient4.setText(mData.get(position).getStrIngredient4());
        holder.strIngredient5.setText(mData.get(position).getStrIngredient5());
        holder.strIngredient6.setText(mData.get(position).getStrIngredient6());
        holder.strIngredient7.setText(mData.get(position).getStrIngredient7());
        holder.strIngredient8.setText(mData.get(position).getStrIngredient8());
        holder.strIngredient9.setText(mData.get(position).getStrIngredient9());
        holder.strIngredient10.setText(mData.get(position).getStrIngredient10());
        holder.strIngredient11.setText(mData.get(position).getStrIngredient11());
        holder.strIngredient12.setText(mData.get(position).getStrIngredient12());
        holder.strIngredient13.setText(mData.get(position).getStrIngredient13());
        holder.strIngredient14.setText(mData.get(position).getStrIngredient14());
        holder.strIngredient15.setText(mData.get(position).getStrIngredient15());
        holder.strIngredient16.setText(mData.get(position).getStrIngredient16());
        holder.strIngredient17.setText(mData.get(position).getStrIngredient17());
        holder.strIngredient18.setText(mData.get(position).getStrIngredient18());
        holder.strIngredient19.setText(mData.get(position).getStrIngredient19());
        holder.strIngredient20.setText(mData.get(position).getStrIngredient20());


        holder.strMeasure1.setText(mData.get(position).getStrMeasure1());
        holder.strMeasure2.setText(mData.get(position).getStrMeasure2());
        holder.strMeasure3.setText(mData.get(position).getStrMeasure3());
        holder.strMeasure4.setText(mData.get(position).getStrMeasure4());
        holder.strMeasure5.setText(mData.get(position).getStrMeasure5());
        holder.strMeasure6.setText(mData.get(position).getStrMeasure6());
        holder.strMeasure7.setText(mData.get(position).getStrMeasure7());
        holder.strMeasure8.setText(mData.get(position).getStrMeasure8());
        holder.strMeasure9.setText(mData.get(position).getStrMeasure9());
        holder.strMeasure10.setText(mData.get(position).getStrMeasure10());
        holder.strMeasure11.setText(mData.get(position).getStrMeasure11());
        holder.strMeasure12.setText(mData.get(position).getStrMeasure12());
        holder.strMeasure13.setText(mData.get(position).getStrMeasure13());
        holder.strMeasure14.setText(mData.get(position).getStrMeasure14());
        holder.strMeasure15.setText(mData.get(position).getStrMeasure15());
        holder.strMeasure16.setText(mData.get(position).getStrMeasure16());
        holder.strMeasure17.setText(mData.get(position).getStrMeasure17());
        holder.strMeasure18.setText(mData.get(position).getStrMeasure18());
        holder.strMeasure19.setText(mData.get(position).getStrMeasure19());
        holder.strMeasure20.setText(mData.get(position).getStrMeasure20());


        Glide.with(mContext)
                .load(mData.get(position).getStrMealThumb())
                .into(holder.strMealThumb);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView strArea;
        TextView strMeal;
        TextView strCategory;
        TextView strDrinkAlternate;
        TextView strInstructions;
        ImageView strMealThumb;
        TextView strYoutube;

        TextView strIngredient1;
        TextView strIngredient2;
        TextView strIngredient3;
        TextView strIngredient4;
        TextView strIngredient5;
        TextView strIngredient6;
        TextView strIngredient7;
        TextView strIngredient8;
        TextView strIngredient9;
        TextView strIngredient10;
        TextView strIngredient11;
        TextView strIngredient12;
        TextView strIngredient13;
        TextView strIngredient14;
        TextView strIngredient15;
        TextView strIngredient16;
        TextView strIngredient17;
        TextView strIngredient18;
        TextView strIngredient19;
        TextView strIngredient20;
        TextView strMeasure1;
        TextView strMeasure2;
        TextView strMeasure3;
        TextView strMeasure4;
        TextView strMeasure5;
        TextView strMeasure6;
        TextView strMeasure7;
        TextView strMeasure8;
        TextView strMeasure9;
        TextView strMeasure10;
        TextView strMeasure11;
        TextView strMeasure12;
        TextView strMeasure13;
        TextView strMeasure14;
        TextView strMeasure15;
        TextView strMeasure16;
        TextView strMeasure17;
        TextView strMeasure18;
        TextView strMeasure19;
        TextView strMeasure20;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            strArea=itemView.findViewById(R.id.strArea);
            strCategory=itemView.findViewById(R.id.strCategory);
            strDrinkAlternate=itemView.findViewById(R.id.strDrinkAlternate);
            strInstructions=itemView.findViewById(R.id.strInstructions);
            strMeal=itemView.findViewById(R.id.strMeal);
            strMealThumb=itemView.findViewById(R.id.strMealThumb);


            strIngredient1=itemView.findViewById(R.id.strIngredient1);
            strIngredient2=itemView.findViewById(R.id.strIngredient2);
            strIngredient3=itemView.findViewById(R.id.strIngredient3);
            strIngredient4=itemView.findViewById(R.id.strIngredient4);
            strIngredient5=itemView.findViewById(R.id.strIngredient5);
            strIngredient6=itemView.findViewById(R.id.strIngredient6);
            strIngredient7=itemView.findViewById(R.id.strIngredient7);
            strIngredient8=itemView.findViewById(R.id.strIngredient8);
            strIngredient9=itemView.findViewById(R.id.strIngredient9);
            strIngredient10=itemView.findViewById(R.id.strIngredient10);
            strIngredient11=itemView.findViewById(R.id.strIngredient11);
            strIngredient12=itemView.findViewById(R.id.strIngredient12);
            strIngredient13=itemView.findViewById(R.id.strIngredient13);
            strIngredient14=itemView.findViewById(R.id.strIngredient14);
            strIngredient15=itemView.findViewById(R.id.strIngredient15);
            strIngredient16=itemView.findViewById(R.id.strIngredient16);
            strIngredient17=itemView.findViewById(R.id.strIngredient17);
            strIngredient18=itemView.findViewById(R.id.strIngredient18);
            strIngredient19=itemView.findViewById(R.id.strIngredient19);
            strIngredient20=itemView.findViewById(R.id.strIngredient20);

            strMeasure1=itemView.findViewById(R.id.strMeasure1);
            strMeasure2=itemView.findViewById(R.id.strMeasure2);
            strMeasure3=itemView.findViewById(R.id.strMeasure3);
            strMeasure4=itemView.findViewById(R.id.strMeasure4);
            strMeasure5=itemView.findViewById(R.id.strMeasure5);
            strMeasure6=itemView.findViewById(R.id.strMeasure6);
            strMeasure7=itemView.findViewById(R.id.strMeasure7);
            strMeasure8=itemView.findViewById(R.id.strMeasure8);
            strMeasure9=itemView.findViewById(R.id.strMeasure9);
            strMeasure10=itemView.findViewById(R.id.strMeasure10);
            strMeasure11=itemView.findViewById(R.id.strMeasure11);
            strMeasure12=itemView.findViewById(R.id.strMeasure12);
            strMeasure13=itemView.findViewById(R.id.strMeasure13);
            strMeasure14=itemView.findViewById(R.id.strMeasure14);
            strMeasure15=itemView.findViewById(R.id.strMeasure15);
            strMeasure16=itemView.findViewById(R.id.strMeasure16);
            strMeasure17=itemView.findViewById(R.id.strMeasure17);
            strMeasure18=itemView.findViewById(R.id.strMeasure18);
            strMeasure19=itemView.findViewById(R.id.strMeasure19);
            strMeasure20=itemView.findViewById(R.id.strMeasure20);



        }
    }
}
