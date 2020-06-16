package com.sdut.chap03;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

public class ActivityDialogTest1 extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.dialog1);
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog;
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("普通对话框")
                .setIcon(R.drawable.icon)
                .setMessage("是否退出应用")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                        ActivityDialogTest1.this.finish();
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
}
