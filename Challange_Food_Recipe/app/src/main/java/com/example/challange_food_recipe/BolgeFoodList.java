package com.example.challange_food_recipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BolgeFoodList {


    @SerializedName("strMeal")
    @Expose
    public String strMeal;

    @SerializedName("idMeal")
    @Expose
    public String idMeal;

    @SerializedName("strMealThumb")
    @Expose
    public String strMealThumb;

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }
}
