package com.recipes.srd.recipes;
import android.app.Application;
import android.util.Log;

import  retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.recipes.srd.recipes.Api.API;
import com.recipes.srd.recipes.Api.Okhttp;
import com.recipes.srd.recipes.db.DaoMaster;
import com.recipes.srd.recipes.db.DaoSession;
import com.recipes.srd.recipes.db.UpdateCheck;
import com.recipes.srd.recipes.db.UpdateCheckDao;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class App extends Application {
    public static final boolean ENCRYPTED = true;
    private DaoSession daoSession;
    private UpdateCheckDao updateCheckDao;
    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"recipe-db"); //The users-db here is the name of our database.
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        updateCheckDao=daoSession.getUpdateCheckDao();

        if(Okhttp.isInternetAvailable(getApplicationContext())){
            API api=Okhttp.getApi();
            Call<List<UpdateCheck>> call=api.update();
            call.enqueue(new Callback<List<UpdateCheck>>() {
                @Override
                public void onResponse(Call<List<UpdateCheck>> call, Response<List<UpdateCheck>> response) {
                    if(response.isSuccessful()){
                        List<UpdateCheck> updateChecks=response.body();
                        if(updateChecks.size()!=0){
                            updateCheckDao.insertInTx(updateChecks);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<UpdateCheck>> call, Throwable t) {
                    Log.e("Error","App Error"+t.getMessage());
                }
            });
        }
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
