package com.esdut.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class MyData {
    public int number;
    private Context context;

    public MyData(Context context) {
        this.context = context;
    }

    public void save() {
        String name = context.getResources().getString(R.string.MY_DATA);
        SharedPreferences shp = context.getSharedPreferences("name",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        String key = context.getResources().getString(R.string.MY_KEY);
        editor.putInt(key,number);
        editor.apply();
    }

    public int load() {
        String name = context.getResources().getString(R.string.MY_DATA);
        SharedPreferences shp = context.getSharedPreferences("name",Context.MODE_PRIVATE);
        String key = context.getResources().getString(R.string.MY_KEY);
        int x =shp.getInt(key,context.getResources().getInteger(R.integer.defvalue));
        number = x;
        return x;
    }

}
