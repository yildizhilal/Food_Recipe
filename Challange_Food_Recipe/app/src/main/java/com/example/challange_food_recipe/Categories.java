package com.example.challange_food_recipe;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categories {


    @SerializedName("strCategory")
    @Expose
    public String strCategory;

    @SerializedName("idCategory")
    @Expose
    public String idCategory;

    @SerializedName("strCategoryThumb")
    @Expose
    public String strCategoryThumb;



    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

}
