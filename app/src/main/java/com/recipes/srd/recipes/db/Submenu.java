package com.recipes.srd.recipes.db;

import com.google.gson.annotations.SerializedName;
import com.recipes.srd.recipes.Api.Globals;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Submenu {
    @SerializedName("id")
    private int id;
    @SerializedName("mid")
    private int mid;
    @SerializedName("name_Gujrati")
    private String name_Gujrati;
    @SerializedName("name_Hindi")
    private String name_Hindi;
    @SerializedName("name_English")
    private String name_English;
    @SerializedName("discription_Gujrati")
    private String discription_Gujrati;
    @SerializedName("discription_Hindi")
    private String discription_Hindi;
    @SerializedName("discription_English")
    private String discription_English;
    @SerializedName("image")
    private String image;
    @Generated(hash = 86912634)
    public Submenu(int id, int mid, String name_Gujrati, String name_Hindi,
            String name_English, String discription_Gujrati,
            String discription_Hindi, String discription_English, String image) {
        this.id = id;
        this.mid = mid;
        this.name_Gujrati = name_Gujrati;
        this.name_Hindi = name_Hindi;
        this.name_English = name_English;
        this.discription_Gujrati = discription_Gujrati;
        this.discription_Hindi = discription_Hindi;
        this.discription_English = discription_English;
        this.image = image;

    }
    @Generated(hash = 660469981)
    public Submenu() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMid() {
        return this.mid;
    }
    public void setMid(int mid) {
        this.mid = mid;
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
    public String getDiscription_Gujrati() {
        return this.discription_Gujrati;
    }
    public void setDiscription_Gujrati(String discription_Gujrati) {
        this.discription_Gujrati = discription_Gujrati;
    }
    public String getDiscription_Hindi() {
        return this.discription_Hindi;
    }
    public void setDiscription_Hindi(String discription_Hindi) {
        this.discription_Hindi = discription_Hindi;
    }
    public String getDiscription_English() {
        return this.discription_English;
    }
    public void setDiscription_English(String discription_English) {
        this.discription_English = discription_English;
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

    public  String getDesc(){
        Globals sharedData = Globals.getInstance();
        switch (sharedData.getValue())
        {
            case 0:
                return discription_Gujrati;
            case 1:
                return discription_Hindi;
            case 2:
                return discription_English;
        }
        return discription_Gujrati;
    }
}
