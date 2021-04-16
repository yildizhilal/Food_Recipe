package com.example.challange_food_recipe;

import retrofit2.Call;
import retrofit2.http.GET;


public interface CategoriesInterface {
    @GET("api/json/v1/1/categories.php")
    Call<CategoriesJsonResponse> getCategory();
}
