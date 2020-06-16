package com.esdut.sichuancuisine;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;


public class ContentFragment extends Fragment {
    private View view;
    private TextView mContent;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f_content,container,false);
        if(view!= null){
            initView();
        }
        setText(((MainActivity)getActivity()).getSettingText()[0]);
        return view;
    }

    private void initView() {
        mContent = view.findViewById(R.id.content);
    }
    public void setText(String text){
        mContent.setText(text);
    }
}
