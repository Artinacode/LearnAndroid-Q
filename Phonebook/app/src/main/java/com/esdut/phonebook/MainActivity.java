package com.esdut.phonebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.function.ToIntBiFunction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Myhelper myHelper;
    private EditText meEtName;
    private EditText meEtPhone;
    private TextView mTvShow;
    private Button mBtnAdd;
    private Button mBtnQuery;
    private Button mBtnUpdate;
    private Button mBtnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHelper = new Myhelper(this);
        init();
    }
    private void init() {
        SQLiteDatabase db;
        meEtName = (EditText) findViewById(R.id.et_name);
        meEtPhone = (EditText) findViewById(R.id.et_phone);
        mTvShow = (TextView) findViewById(R.id.tv_show);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnUpdate = (Button) findViewById(R.id.btn_update);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnAdd.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        db = myHelper.getReadableDatabase();
        Cursor cursor = db.query("information",null,null,null,
                null,null,null);
        if(cursor.getCount() == 0) {
            mTvShow.setText("");
            Toast.makeText(this,"no date",Toast.LENGTH_LONG).show();
        }else{
            cursor.moveToFirst();
            mTvShow.setText("Name :"+cursor.getString(1) + " \n TEL :" + cursor.getString(2)+"\n");
        }
        while(cursor.moveToNext()){
            mTvShow.append("\n" + "Name : " + cursor.getString(1) + " \n Tel : " + cursor.getString(2) +"\n");
        }
        cursor.close();
        db.close();
    }

    @Override
    public void onClick(View v) {
        String name, phone;
        SQLiteDatabase db;
        ContentValues values;
        switch(v.getId()){
            case R.id.btn_add:
                name = meEtName.getText().toString();
                phone = meEtPhone.getText().toString();
                db = myHelper.getWritableDatabase();
                values = new ContentValues();
                values.put("name",name);
                values.put("phone",phone);
                db.insert("information",null,values);
                Toast.makeText(this,"imformation has been added",Toast.LENGTH_LONG).show();
                db.close();
            case R.id.btn_query:
                db = myHelper.getReadableDatabase();
                Cursor cursor = db.query("information",null,null,null,
                        null,null,null);
                if(cursor.getCount() == 0) {
                    mTvShow.setText("");
                    Toast.makeText(this,"no date",Toast.LENGTH_LONG).show();
                }else{
                    cursor.moveToFirst();
                    mTvShow.setText("Name :"+cursor.getString(1) + " \n TEL :" + cursor.getString(2)+"\n");
                }
                while(cursor.moveToNext()){
                    mTvShow.append("\n" + "Name : " + cursor.getString(1) + " \n\n Tel : " + cursor.getString(2)+"\n");
                }
                cursor.close();
                db.close();
                break;
            case R.id.btn_update:
                db = myHelper.getWritableDatabase();
                values = new ContentValues();
                values.put("phone",phone = meEtPhone.getText().toString());
                db.update("information",values,"name=?",
                        new String[]{meEtName.getText().toString()});
                Toast.makeText(this,"sucess", Toast.LENGTH_LONG).show();
                db.close();
                break;
            case R.id.btn_delete:
                db = myHelper.getWritableDatabase();
                db.delete("information",null,null);
                Toast.makeText(this,"has been deleted",Toast.LENGTH_LONG).show();
                mTvShow.setText("");
                db.close();
                break;
        }
    }
}

class Myhelper extends SQLiteOpenHelper {


    public Myhelper(@Nullable Context context) {
        super(context, "esdut.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE information(_id INTEGER　PRIMARY KEY AUTOINCREMENT,name VARCHAR(20), phone VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}