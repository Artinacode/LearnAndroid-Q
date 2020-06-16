package com.esdut.sichuancuisine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;


public class MenuFragment extends Fragment {
    private View view;
    private  int[] settingicon;
    private  String[] foodNames;
    private String[] settingText;
    private ListView mLisView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f_menu,container,false);
        MainActivity activity =(MainActivity)getActivity();
        settingicon = activity.geticons();
        foodNames = activity.getNames();
        settingText = activity.getSettingText();
        if(view != null){
            initView();
        }
        mLisView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ContentFragment listFragment = (ContentFragment)((MainActivity)
////                        getActivity()).getFragmentManager().findFragmentById(R.id.foodcontent);
                ContentFragment lc=(ContentFragment) ((MainActivity)getActivity()).getFragmentManager().findFragmentById(R.id.foodcontent);
                lc.setText(settingText[position]);

            }
        });
        return view;
    }
    private void initView(){
        mLisView = (ListView)view.findViewById(R.id.menu_list);
        if(settingicon!= null){
            mLisView.setAdapter(new MyAdapter());
        }
    }
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return settingicon.length;
        }

        @Override
        public Object getItem(int position) {
            return settingicon[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(getActivity(),R.layout.item_list,null);
            ImageView mNameTV = (ImageView) convertView
                    .findViewById(R.id.food_icon);
            mNameTV.setBackgroundResource(settingicon[position]);
            TextView mFoodName = (TextView) convertView.findViewById
                    (R.id.food_name);
            mFoodName.setText(foodNames[position]);
            return convertView;
        }
    }
}
