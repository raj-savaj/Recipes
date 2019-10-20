package com.recipes.srd.recipes.db;

import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.recipes.srd.recipes.Api.Globals;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Recipe {

    @SerializedName("id")
    private int id;
    @SerializedName("name_Gujrati")
    private String name_Gujrati;
    @SerializedName("name_Hindi")
    private String name_Hindi;
    @SerializedName("name_English")
    private String name_English;
    @SerializedName("image")
    private String image;
    @Generated(hash = 1729793885)
    public Recipe(int id, String name_Gujrati, String name_Hindi,
            String name_English, String image) {
        this.id = id;
        this.name_Gujrati = name_Gujrati;
        this.name_Hindi = name_Hindi;
        this.name_English = name_English;
        this.image = image;
    }
    @Generated(hash = 829032493)
    public Recipe() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName_Gujrati() {
        return this.name_Gujrati;
    }
    public void setName_Gujrati(String name_Gujrati) {
        this.name_Gujrati = name_Gujrati;
    }
    public String getName_Hindi() {
        return this.name_Hindi;
    }
    public void setName_Hindi(String name_Hindi) {
        this.name_Hindi = name_Hindi;
    }
    public String getName_English() {
        return this.name_English;
    }
    public void setName_English(String name_English) {
        this.name_English = name_English;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getName(){
        Globals sharedData = Globals.getInstance();
        switch (sharedData.getValue())
        {
            case 0:
                return name_Gujrati;
            case 1:
                return name_Hindi;
            case 2:
                return name_English;
        }
        return name_Gujrati;
    }
}
