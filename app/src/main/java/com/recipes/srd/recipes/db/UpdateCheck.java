package com.recipes.srd.recipes.db;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UpdateCheck {
    @SerializedName("id")
    private int id;
    @SerializedName("mid")
    private int mid;
    @SerializedName("sid")
    private int sid;
    @Generated(hash = 507698695)
    public UpdateCheck(int id, int mid, int sid) {
        this.id = id;
        this.mid = mid;
        this.sid = sid;
    }
    @Generated(hash = 1051926719)
    public UpdateCheck() {
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
    public int getSid() {
        return this.sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
}
