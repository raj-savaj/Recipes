package com.recipes.srd.recipes.Api;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.recipes.srd.recipes.db.Recipe;
import com.recipes.srd.recipes.db.Submenu;

public class SessionManager {

    SharedPreferences pref;

    Editor editor;

    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "SRDRecipes";


    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setRecipes(Recipe recipe){
        Gson gson = new Gson();
        String json = gson.toJson(recipe);
        editor.putString("recipe", json);
        editor.commit();
    }

    public Recipe getRecipes(){
        Gson g=new Gson();
        String json=pref.getString("recipe","");
        return g.fromJson(json,Recipe.class);
    }

    public void setSubmenu(Submenu submenu){
        Gson gson = new Gson();
        String json = gson.toJson(submenu);
        editor.putString("submenu", json);
        editor.commit();
    }

    public Submenu getSubmenu(){
        Gson g=new Gson();
        String json=pref.getString("submenu","");
        return g.fromJson(json,Submenu.class);
    }

    public void setLang(int  lang){
        editor.putInt("lang",lang );
        editor.commit();
    }

    public int getLang(){
        return pref.getInt("lang",0);
    }
}

