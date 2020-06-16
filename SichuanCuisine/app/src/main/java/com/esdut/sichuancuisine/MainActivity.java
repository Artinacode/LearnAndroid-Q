package com.esdut.sichuancuisine;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction beginTransaction;
    //设置文字
    private String[] settingText = {
            "1.将小猪抓起来\n" +
            "2.去除猪毛\n" +
            "3.清蒸即可",
            "1.将小牛抓起来\n" +
                    "2.去除牛毛\n" +
                    "3.红烧即可"
    };
    private int[] settingicons = {R.drawable.mm,R.drawable.nn};
    private String[] foodNames = {"清蒸小猪","红烧小牛"};
    public int[] geticons(){
        return settingicons;
    }
    public String[] getNames(){
        return foodNames;
    }
    public String[] getSettingText(){
        return settingText;
    }
    @SuppressLint("CommitTransaction")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentFragment contentFragment = new ContentFragment();
        MenuFragment menuFragment = new MenuFragment();
        beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.foodcontent,contentFragment);
        beginTransaction.replace(R.id.menu,menuFragment);
        beginTransaction.commit();
//        MenuFragment menu=new MenuFragment();
//        ContentFragment content=new ContentFragment();
//        FragmentTransaction ft=getFragmentManager().beginTransaction();
//        ft.replace(R.id.foodcontent,content);
//        ft.replace(R.id.menu,menu);
//        ft.commit();
    }
}