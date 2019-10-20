package com.recipes.srd.recipes;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.recipes.srd.recipes.Adapter.proadepter;
import com.recipes.srd.recipes.Api.API;
import com.recipes.srd.recipes.Api.Globals;
import com.recipes.srd.recipes.Api.Okhttp;
import com.recipes.srd.recipes.Api.SessionManager;
import com.recipes.srd.recipes.db.DaoSession;
import com.recipes.srd.recipes.db.Recipe;
import com.recipes.srd.recipes.db.RecipeDao;
import com.recipes.srd.recipes.db.Submenu;
import com.recipes.srd.recipes.db.SubmenuDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    DaoSession daoSession;
    Toolbar myToolbar;
    Spinner mySpinner;
    SessionManager sessionManager;
    RecyclerView rcv;
    List<Recipe> recipes;
    RecipeDao recipeDao;
    Globals sharedData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));


        daoSession = ((App) getApplication()).getDaoSession();
        recipeDao=daoSession.getRecipeDao();
        setData();
        sessionManager=new SessionManager(MainActivity.this);
        getSupportActionBar().hide();
        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        mySpinner = (Spinner) findViewById(R.id.spinner);

        myToolbar.setTitle(getResources().getString(R.string.app_name));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lang, R.layout.custom_textview_to_spinner);
        adapter.setDropDownViewResource( R.layout.custom_textview_to_spinner);
        mySpinner.setAdapter(adapter);
        mySpinner.setSelection(sessionManager.getLang());

        sharedData = Globals.getInstance();
        sharedData.setValue(sessionManager.getLang());

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              if(sessionManager.getLang()!=i){
                  sessionManager.setLang(i);
                  if(recipes!=null){
                      recipes.clear();
                  }
                  sharedData.setValue(sessionManager.getLang());
                  setData();
              }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if (Okhttp.isInternetAvailable(MainActivity.this)) {
            API api= Okhttp.getApi();
            Call<List<Submenu>> call = api.getSubmenu();
            call.enqueue(new Callback<List<Submenu>>() {
                @Override
                public void onResponse(Call<List<Submenu>> call, Response<List<Submenu>> response) {
                    if(response.isSuccessful()){
                        List<Submenu> submenus=response.body();
                        SubmenuDao submenuDao=daoSession.getSubmenuDao();
                        if(submenuDao.count()!=submenus.size()){
                            submenuDao.deleteAll();
                            submenuDao.insertInTx(submenus);
                        }
                    }else{
                        Log.e("Response Error",""+response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<Submenu>> call, Throwable t) {
                    Log.e("Error",t.getMessage());
                }
            });

        }
    }

    public void setData(){
        recipes=recipeDao.loadAll();
        rcv.setAdapter(new proadepter(recipes));
    }
}

