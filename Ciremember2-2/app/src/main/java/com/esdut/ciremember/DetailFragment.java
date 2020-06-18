package com.esdut.ciremember;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailFragment extends Fragment {



    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        WebView myWebView = (WebView) requireActivity().findViewById(R.id.web);
        myWebView.setWebViewClient(new WebViewClient());

        WebSettings settings = myWebView.getSettings();
        myWebView.setInitialScale(200);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        String u = requireActivity().getIntent().getStringExtra("word");
        myWebView.loadUrl("https://m.youdao.com/dict?le=eng&q=" + u);
    }
}