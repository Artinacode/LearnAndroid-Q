package com.esdut.intent_information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data","hello QGW");
                setResult(2,intent);
                finish();
            }
        });
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("studentName");
//        Toast.makeText(MainActivity2.this,"获取到的姓名为："+name,Toast.LENGTH_LONG).show();
//        Bundle bundle = getIntent().getExtras();
//        String account = bundle.getString("account");
//        Toast.makeText(this,account,Toast.LENGTH_LONG).show();




    }
}