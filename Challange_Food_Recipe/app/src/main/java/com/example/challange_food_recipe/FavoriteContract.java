package com.example.challange_food_recipe;

import android.provider.BaseColumns;

public class FavoriteContract {

    public static final class FavoriteEntry implements BaseColumns {

        public static final String TABLE_NAME = "favorite";
        public static final String COLUMN_FOODID = "food";
        public static final String COLUMN_TITLE = "title";
    }
}
