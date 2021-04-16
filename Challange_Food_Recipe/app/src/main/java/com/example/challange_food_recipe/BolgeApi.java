package com.example.challange_food_recipe;


import retrofit2.Call;
import retrofit2.http.GET;

public interface BolgeApi {
    @GET("api/json/v1/1/list.php?a=list")
    Call<BolgeJSonResponse> getBolge();
}
