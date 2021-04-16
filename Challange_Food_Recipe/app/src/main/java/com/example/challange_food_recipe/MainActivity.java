package com.example.challange_food_recipe;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.Arrays.*;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    RecyclerView recyclerView, recyclerViewCategories;
    ProgressBar pgsBar;
    List<Bolge> bolgeList;
    AdapteryFood adapter;
    List<Food> foodList;
    private FavoriteHelper favoriteDbHelper;
    private AppCompatActivity activity = MainActivity.this;
    List<Categories> categoriesList;

    public static final String LOG_TAG = AdapteryFood.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pgsBar = (ProgressBar) findViewById(R.id.pBar);
        recyclerView = findViewById(R.id.recylecler2);
        bolgeList = new ArrayList<>();
        foodList=new ArrayList<>();
        recyclerViewCategories = findViewById(R.id.recylecler);
        categoriesList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        showLoading();
        BolgeApi bolgeApi = retrofit.create(BolgeApi.class);

        Call<BolgeJSonResponse> call = bolgeApi.getBolge();

        call.enqueue(new Callback<BolgeJSonResponse>() {
            @Override
            public void onResponse(Call<BolgeJSonResponse> call, Response<BolgeJSonResponse> response) {
                hideLoading();
                BolgeJSonResponse bolgeJSonResponse = response.body();
                if (response.isSuccessful() && response.body() != null) {
                    bolgeList = new ArrayList<>(asList(bolgeJSonResponse.getMeals()));
                    PutDataIntoRecyclerView(bolgeList);
                }
            }

            @Override
            public void onFailure(Call<BolgeJSonResponse> call, Throwable t) {

            }
        });

        CategoriesInterface categoriesInterface = retrofit.create(CategoriesInterface.class);
        Call<CategoriesJsonResponse> callCategories = categoriesInterface.getCategory();

        callCategories.enqueue(new Callback<CategoriesJsonResponse>() {
            @Override
            public void onResponse(Call<CategoriesJsonResponse> call, Response<CategoriesJsonResponse> response) {
                hideLoading();
                CategoriesJsonResponse categoriesJsonResponse = response.body();
                if (response.isSuccessful() && response.body() != null) {

                    categoriesList = new ArrayList<>(Arrays.asList(categoriesJsonResponse.getCategories()));

                    PutDataIntoRecyclerViewCategories(categoriesList);
                }
            }

            @Override
            public void onFailure(Call<CategoriesJsonResponse> call, Throwable t) {

            }
        });


    }
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s){
        Log.d(LOG_TAG, "Preferences updated");
    }

    private void getAllFavorite(){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params){
                foodList.clear();
                foodList.addAll(favoriteDbHelper.getAllFavorite());
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }

    private void PutDataIntoRecyclerView(List<Bolge> bolgeList) {
        AdapteryBolge adaptery = new AdapteryBolge(this, bolgeList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adaptery);

    }

    private void PutDataIntoRecyclerViewCategories(List<Categories> catList) {
        AdapteryCategories adaptery = new AdapteryCategories(this, catList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewCategories.setLayoutManager(mLayoutManager);
        recyclerViewCategories.setAdapter(adaptery);

    }

    public void showLoading() {
        pgsBar.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        pgsBar.setVisibility(View.GONE);
    }
}

