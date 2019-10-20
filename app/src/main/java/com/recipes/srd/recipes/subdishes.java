package com.recipes.srd.recipes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.recipes.srd.recipes.Adapter.subadepter;
import com.recipes.srd.recipes.Api.SessionManager;
import com.recipes.srd.recipes.db.DaoSession;
import com.recipes.srd.recipes.db.Recipe;
import com.recipes.srd.recipes.db.RecipeDao;
import com.recipes.srd.recipes.db.Submenu;
import com.recipes.srd.recipes.db.SubmenuDao;

import java.util.List;

public class subdishes extends AppCompatActivity {

    DaoSession daoSession;
    RecyclerView recyclerView;
    List<Submenu> submenus;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subdishes);
        RecyclerView sub = findViewById(R.id.sub);
        sub.setLayoutManager(new LinearLayoutManager(this));
        recyclerView = findViewById(R.id.rcv);
        sessionManager=new SessionManager(subdishes.this);
        Recipe recipe=sessionManager.getRecipes();

        daoSession = ((App) getApplication()).getDaoSession();
        SubmenuDao recipeDao=daoSession.getSubmenuDao();
        submenus=recipeDao.queryBuilder().where(SubmenuDao.Properties.Mid.eq(recipe.getId())).list();
        sub.setAdapter(new subadepter(submenus));

        getSupportActionBar().setTitle(recipe.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
