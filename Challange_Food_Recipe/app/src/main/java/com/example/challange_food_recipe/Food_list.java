package com.example.challange_food_recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.Arrays.asList;

public class Food_list extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar pgsBar;
    private final AppCompatActivity activity = Food_list.this;
    private FavoriteHelper favoriteDbHelper;
    private Food favorite;
    List<BolgeFoodList> bolgeFoodList;
    List<Categories> categoryFoodList;

    Food food;
    String foodID, foodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        pgsBar = (ProgressBar) findViewById(R.id.pBar);
        recyclerView = findViewById(R.id.recyleclerFoodList);
        bolgeFoodList = new ArrayList<>();
        categoryFoodList = new ArrayList<>();


        Bundle choice = getIntent().getExtras();
        String Region = choice.getString("veri");

        String Category2 = choice.getString("category");


        if (Region == null) {
            function(null, Category2);
        } else if (Category2 == null) {
            function(Region, null);
        }

    }


    private void function(String region, String category) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BolgeApiFoodList bolgeApiFoodList = retrofit.create(BolgeApiFoodList.class);

        showLoading();
        Call<BolgeFoodListJSonResponse> call = bolgeApiFoodList.getBolgeFoodList(region, category);
        call.enqueue(new Callback<BolgeFoodListJSonResponse>() {
            @Override
            public void onResponse(Call<BolgeFoodListJSonResponse> call, Response<BolgeFoodListJSonResponse> response) {
                hideLoading();
                BolgeFoodListJSonResponse bolgeFoodListJSonResponse = response.body();
                if (response.isSuccessful() && response.body() != null) {
                    bolgeFoodList = new ArrayList<>(asList(bolgeFoodListJSonResponse.getMeals()));

                    PutDataIntoRecyclerView(bolgeFoodList);
                }
            }

            @Override
            public void onFailure(Call<BolgeFoodListJSonResponse> call, Throwable t) {

            }
        });
    }

    private void PutDataIntoRecyclerView(List<BolgeFoodList> bolgeFoodList) {
        AdapteryFoodList adaptery = new AdapteryFoodList(this, bolgeFoodList);
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


    public void saveFavorite(){
        favoriteDbHelper = new FavoriteHelper(activity);
        favorite = new Food();

        favorite.setIdMeal(foodID);
        favorite.setStrMeal(foodName);

        favoriteDbHelper.addFavorite(favorite);
    }



}


