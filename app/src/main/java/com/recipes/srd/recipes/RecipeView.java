package com.recipes.srd.recipes;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.recipes.srd.recipes.Api.API;
import com.recipes.srd.recipes.Api.Okhttp;
import com.recipes.srd.recipes.Api.SessionManager;
import com.recipes.srd.recipes.db.Submenu;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class RecipeView extends AppCompatActivity {

    SessionManager sessionManager;
    ImageView recipeimg;
    TextView txtname;
    WebView txtdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);
        sessionManager=new SessionManager(RecipeView.this);
        Submenu submenu=sessionManager.getSubmenu();
        getSupportActionBar().setTitle(submenu.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recipeimg=findViewById(R.id.recipe);
        txtname=findViewById(R.id.recipetext);
        txtdesc=findViewById(R.id.dis);

        txtdesc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        txtdesc.setLongClickable(false);
        txtdesc.setHapticFeedbackEnabled(false);
        if(Okhttp.isInternetAvailable(RecipeView.this)){
            Picasso.with(RecipeView.this)
                    .load(API.IMG_URL+submenu.getImage().replaceAll(" ", "%20"))
                    .into(recipeimg);
        }
        else {
            Picasso.with(RecipeView.this)
                    .load(API.IMG_URL+submenu.getImage().replaceAll(" ", "%20"))
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(recipeimg);
        }
        txtname.setText(submenu.getName());
        txtdesc.loadDataWithBaseURL("",submenu.getDesc(),"text/html","UTF-8","");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
