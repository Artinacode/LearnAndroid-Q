package com.sdut.chap03;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Activity3 extends Activity implements CompoundButton.OnCheckedChangeListener {
private String sex;
private String hobby;
private RadioGroup rgSex;
private TextView txtInfo,txtInfo1;
private CheckBox chSwim,chRead,chSleep,chPlay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testradio);
        txtInfo=(TextView) findViewById(R.id.txtInfo);
        txtInfo1=(TextView) findViewById(R.id.txtInfo1);
        chSwim=(CheckBox) findViewById(R.id.chSwim);
        chRead=(CheckBox) findViewById(R.id.chRead);
        chSleep=(CheckBox) findViewById(R.id.chSleep);
        chPlay=(CheckBox) findViewById(R.id.chPlay);
        rgSex=(RadioGroup) findViewById(R.id.rgSex);
        chSwim.setOnCheckedChangeListener(this);
        chRead.setOnCheckedChangeListener(this);
        chSleep.setOnCheckedChangeListener(this);
        chPlay.setOnCheckedChangeListener(this);
        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rdMale)
                {
                    sex="男";
                    txtInfo.setText("你的性别是："+sex);
                }
                else{
                    sex="女";
                    txtInfo.setText("你的性别是："+sex);
                }
            }
        });
     hobby=new String();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       String xz=buttonView.getText().toString();
       if (isChecked)
       {
           if(!hobby.contains(xz))
           {
               Toast.makeText(Activity3.this,xz,Toast.LENGTH_LONG).show();
               hobby=hobby+xz;
           }
           txtInfo1.setText(hobby);
       }else {
           if (hobby.contains(xz))
           {
               hobby=hobby.replace(xz,"");
           }
           txtInfo1.setText(hobby);
       }
    }
}
