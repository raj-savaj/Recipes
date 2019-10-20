package com.recipes.srd.recipes;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.github.florent37.viewanimator.ViewAnimator;
import com.recipes.srd.recipes.Api.Okhttp;
import com.recipes.srd.recipes.db.DaoSession;
import com.recipes.srd.recipes.db.Recipe;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.recipes.srd.recipes.Api.API;
import com.recipes.srd.recipes.db.RecipeDao;

import java.util.List;

public class Splash extends AppCompatActivity {

    DaoSession daoSession;
    TextView text;
    private static int SPLASH_TIME_OUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        text=findViewById(R.id.text);
        ViewAnimator
                .animate(text)
                .scale(0,1)
                .tada()
                .repeatCount(20)
                .start();

        daoSession = ((App) getApplication()).getDaoSession();

        if ((Okhttp.isInternetAvailable(Splash.this))) {
            API api= Okhttp.getApi();
            Call<List<Recipe>> call = api.getRecipes();
            call.enqueue(new Callback<List<Recipe>>() {
                @Override
                public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                    if(response.isSuccessful()){
                        List<Recipe> recipes=response.body();
                        RecipeDao recipeDao=daoSession.getRecipeDao();
                        if(recipeDao.count()!=recipes.size()){
                            recipeDao.deleteAll();
                            recipeDao.insertInTx(recipes);
                        }
                    }else{
                        Log.e("Response Error",""+response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<Recipe>> call, Throwable t) {
                    Log.e("Error",t.getMessage());
                }
            });
        }
        new Handler().postDelayed(new Thread(), (long) SPLASH_TIME_OUT);

    }

    class Thread implements Runnable {
        Thread() {
        }

        public void run() {
            Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
            Splash.this.finish();
        }
    }
}
