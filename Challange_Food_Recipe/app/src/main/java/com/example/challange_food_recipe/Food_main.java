package com.example.challange_food_recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.Arrays.asList;
public class Food_main extends AppCompatActivity {

    List<Food> FoodList;
    RecyclerView recyclerView;
    ProgressBar pgsBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_main);


        recyclerView=findViewById(R.id.recyleclerFood);
        pgsBar = (ProgressBar) findViewById(R.id.pBar);
        FoodList =new ArrayList<>();


        Bundle id=getIntent().getExtras();
        String ID= id.getString("id");

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FoodApi foodApi  =retrofit.create(FoodApi.class);
        showLoading();
        Call<FoodJsonResponse> call=foodApi.getFood(ID);
        call.enqueue(new Callback<FoodJsonResponse>() {
            @Override
            public void onResponse(Call<FoodJsonResponse> call, Response<FoodJsonResponse> response) {
                hideLoading();
                FoodJsonResponse foodJsonResponse=response.body();
                if (response.isSuccessful() && response.body() != null) {
                    FoodList = new ArrayList<>(asList(foodJsonResponse.getMeals()));

                    PutDataIntoRecyclerView(FoodList);
                }
            }

            @Override
            public void onFailure(Call<FoodJsonResponse> call, Throwable t) {

            }
        });




    }

    private void PutDataIntoRecyclerView(List<Food> foods) {
        AdapteryFood adaptery = new AdapteryFood(this,foods);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adaptery);
    }

    public void showLoading() {
        pgsBar.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        pgsBar.setVisibility(View.GONE);
    }
}