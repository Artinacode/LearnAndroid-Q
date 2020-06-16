package com.sdut.fragmenttest;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContentFragment extends Fragment {
    private View view;
    private TextView txtContent;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_content,container,false);
         if(view!=null)
         {
             initView();
         }
         //
         setText(((MainActivity)getActivity()).getSettingText()[0]);
        //
        return view;
    }
    public void initView()
    {
        txtContent=(TextView) view.findViewById(R.id.txtContent);
    }
    public void setText(String text)
    {
        txtContent.setText(text);
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
    }
}
