package com.sdut.chap03;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class ActivityDialogTest4 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog4);
        ((Button)findViewById(R.id.btn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CommonDialog dialog=new CommonDialog(ActivityDialogTest4.this);
                dialog.setTitle("提示");
                dialog.setMessage("你确定要删除信息？");
                dialog.setPostive("确定");
                dialog.setNegtive("取消");
                dialog.setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onNegtiveClick() {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }


}
