package com.example.challange_food_recipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface FoodApi {
    @GET("api/json/v1/1/lookup.php")
    Call<FoodJsonResponse> getFood(@Query("i") String i);

}
