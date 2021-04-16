package com.example.challange_food_recipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bolge {
    @SerializedName("strArea")
    @Expose
    public String strArea;

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }
}