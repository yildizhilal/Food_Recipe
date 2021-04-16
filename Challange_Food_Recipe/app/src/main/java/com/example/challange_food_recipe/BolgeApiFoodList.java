package com.example.challange_food_recipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BolgeApiFoodList { @GET("api/json/v1/1/filter.php")
Call<BolgeFoodListJSonResponse> getBolgeFoodList(@Query("a") String a,@Query("c") String c );
}