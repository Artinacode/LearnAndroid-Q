package com.esdut.intent_information;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.button:
////                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
//////                intent.putExtra("studentName","小明");
//
//                Intent intent = new Intent();
//                intent.setClass(this,MainActivity2.class);
//
//                Bundle bundle = new Bundle();
//                bundle.putString("account","江小白");
//                intent.putExtras(bundle);
//                startActivity(intent);
//                break;
            case R.id.bt2:
                Intent intent1 = new Intent();
                intent1.setClass(this,MainActivity2.class);
                startActivityForResult(intent1,1);
                break;
            default:

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            String acquiredData = data.getStringExtra("data");
            Toast.makeText(this,acquiredData,Toast.LENGTH_LONG).show();
        }
    }
}