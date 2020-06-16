package com.esdut.roombasic1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());

        WebSettings settings = myWebView.getSettings();
        myWebView.setInitialScale(200);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        String u = getIntent().getStringExtra("word");
//        String uri = "\"http://dict.kekenet.com/en/ " + u + "\"";
//        myWebView.loadUrl("http://dict.kekenet.com/en/"+u);
//        myWebView.loadUrl("https://dict.hjenglish.com/w/" + u);
        myWebView.loadUrl("http://dict.youdao.com/w/" + u);
//        myWebView.requestFocus(View.FOCUS_DOWN);
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}