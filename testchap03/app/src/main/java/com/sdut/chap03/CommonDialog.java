package com.sdut.chap03;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CommonDialog extends AlertDialog {
    private TextView txtTile,txtMessage;
    private Button btnNegtive,btnPostive;
    private String mesage;
    private String title;
    private String negtive;
    private String postive;
    protected CommonDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        initView();
        initEvent();
    }
    private void initView()
    {
        txtTile=(TextView) findViewById(R.id.txtTitle);
        txtMessage=(TextView) findViewById(R.id.txtMessage);
        btnNegtive=(Button) findViewById(R.id.btnNegtive);
        btnPostive=(Button) findViewById(R.id.btnPostive);
    }
    private void initEvent()
    {
        btnPostive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickBottomListener!=null)
                {
                    onClickBottomListener.onPositiveClick();
                }
            }
        });
        btnNegtive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickBottomListener!=null)
                {
                    onClickBottomListener.onNegtiveClick();
                }
            }
        });
    }
private void refreshView()
{
    if(!TextUtils.isEmpty(title))
    {
        txtTile.setText(title);
        txtTile.setVisibility(View.VISIBLE);
    }else {
        txtTile.setVisibility(View.GONE);
    }
    if(!TextUtils.isEmpty(mesage))
    {
        txtMessage.setText(mesage);
    }
    if(!TextUtils.isEmpty(negtive))
    {
        btnNegtive.setText(negtive);
    }else{
        btnNegtive.setText("取消");
    }
    if(!TextUtils.isEmpty(postive))
    {
        btnPostive.setText(postive);
    }else{
        btnPostive.setText("确定");
    }
}

    @Override
    public void show() {
        super.show();
        refreshView();
    }

    public interface  OnClickBottomListener
    {
        void onPositiveClick();
        void onNegtiveClick();
    }
    public OnClickBottomListener onClickBottomListener;
    public CommonDialog setOnClickBottomListener(OnClickBottomListener onClickBottomListener)
    {
        this.onClickBottomListener=onClickBottomListener;
        return  this;
    }
    public CommonDialog setTitle(String title)
    {
        this.title=title;
        return this;
    }
    public CommonDialog setMessage(String mesage)
    {
        this.mesage=mesage;
        return this;
    }
    public CommonDialog setPostive(String postive)
    {
        this.postive=postive;
        return this;
    }
    public CommonDialog setNegtive(String negtive)
    {
        this.negtive=negtive;
        return this;
    }
}
