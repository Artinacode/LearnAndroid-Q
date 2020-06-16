package com.sdut.chap03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //1.声明相关控件对象
    private TextView txtName;
    private Button btnTest1,btnTest2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.获取这个控件对象
        txtName=(TextView) findViewById(R.id.txtName);
        btnTest1=(Button) findViewById(R.id.btnTest1);
        btnTest2=(Button) findViewById(R.id.btnTest2);
        //3.可以去使用
        txtName.setText("山东理工大学（SDUT）");

        //3.按钮事件处理匿名内部类
     /*   btnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button","按了按钮111111111");
            }
        });*/
     btnTest1.setOnClickListener(this);
     btnTest2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnTest1:
                Log.i("button","按了按钮111111111");
                break;
            case R.id.btnTest2:
                Log.i("button","按了按钮222222222");
                break;
        }
    }
}
