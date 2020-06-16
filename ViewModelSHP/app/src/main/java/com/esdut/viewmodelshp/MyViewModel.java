package com.esdut.viewmodelshp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

@SuppressWarnings("ConstantConditions")
public class MyViewModel extends AndroidViewModel {
//    // 这里也可以定义context
//    Application application;

    SavedStateHandle handle;
    String key = getApplication().getResources().getString(R.string.data_key);
    String shpname = getApplication().getResources().getString(R.string.shp_name);

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;

        if (!handle.contains(key)) {
            load();
        }
    }

    public LiveData<Integer> getNumber() {
        return handle.getLiveData(key);
    }

    public void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpname, Context.MODE_PRIVATE);
        int x = shp.getInt(key, 0);
        handle.set(key, x);
    }

    public void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpname, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(key, getNumber().getValue());
        editor.apply();
    }

    public void add(int x) {
        handle.set(key, getNumber().getValue() == null ? 0 : getNumber().getValue() + x);
        //save();
    }

}
