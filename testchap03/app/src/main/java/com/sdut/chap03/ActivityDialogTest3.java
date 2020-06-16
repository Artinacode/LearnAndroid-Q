package com.sdut.chap03;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ActivityDialogTest3 extends Activity {
    private Button btn1;
    private TextView txtInfo;
    private int[] textSizeArr={10,20,30,40,50};
    int textSize=1;
    private CharSequence[] items=new CharSequence[]{"旅游","美食","读书","运动"};
    private boolean[] checkItems=new boolean[]{false,false,false,false};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog3);
        btn1=(Button) findViewById(R.id.btn1);
        txtInfo=(TextView) findViewById(R.id.txtInfo);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                AlertDialog.Builder builder=new AlertDialog.Builder(ActivityDialogTest3.this)
                        .setTitle("设置字体大小")
                        .setIcon(R.drawable.icon)
                        .setMultiChoiceItems(items, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkItems[which]=isChecked;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                StringBuffer sb=new StringBuffer();
                                for(int i=0;i<checkItems.length-1;i++)
                                {
                                    if(checkItems[i])
                                    {
                                        sb.append(items[i]+"  ");
                                    }
                                }
                                txtInfo.setText(sb.toString());
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dialog=builder.create();
                dialog.show();
            }
        });
    }
}
