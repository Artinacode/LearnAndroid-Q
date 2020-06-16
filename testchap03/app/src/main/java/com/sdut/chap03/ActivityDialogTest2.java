package com.sdut.chap03;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ActivityDialogTest2 extends Activity {
    private Button btn1;
    private TextView txt1;
    private int[] textSizeArr={10,20,30,40,50};
    int textSize=1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog2);
        btn1=(Button) findViewById(R.id.btn1);
        txt1=(TextView) findViewById(R.id.txt1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                AlertDialog.Builder builder=new AlertDialog.Builder(ActivityDialogTest2.this)
                        .setTitle("设置字体大小")
                        .setIcon(R.drawable.icon)
                        .setSingleChoiceItems(new String[]{"小号", "默认", "中号", "大号", "超大号"}, textSize, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                textSize=which;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                               txt1.setTextSize(textSizeArr[textSize]);
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
