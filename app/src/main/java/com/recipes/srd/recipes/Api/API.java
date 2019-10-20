package com.recipes.srd.recipes.Api;

import com.recipes.srd.recipes.db.Recipe;
import com.recipes.srd.recipes.db.Submenu;
import com.recipes.srd.recipes.db.UpdateCheck;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://srdrecipes.herokuapp.com/api/";
    String IMG_URL="https://s3.ap-south-1.amazonaws.com/srdrecipes/";

    @GET("menu")
    Call<List<Recipe>> getRecipes();

    @GET("submenu")
    Call<List<Submenu>> getSubmenu();

    @GET("updatecheck")
    Call<List<UpdateCheck>> update();
}
