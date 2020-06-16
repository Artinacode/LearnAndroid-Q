package com.sdut.fragmenttest;

import android.app.Fragment;
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

public class MenuFragment extends Fragment {
    private View view;
    private int[] icons;
    private String[] foodNames;
    private String[] settingText;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_menu,container,false);
        MainActivity activity=(MainActivity) getActivity();
        icons=activity.getIcons();
        foodNames=activity.getNames();
        settingText=activity.getSettingText();
        if(view!=null)
        {
            initView();
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContentFragment lc=(ContentFragment) ((MainActivity)getActivity()).getFragmentManager().findFragmentById(R.id.foodcontent);
                lc.setText(settingText[position]);

            }
        });

        return view;
    }
    public void initView()
    {
        lv=(ListView) view.findViewById(R.id.menuls);
        if (icons!=null)
        {
            lv.setAdapter(new MyAdapter());
        }
    }
    class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return icons.length;
        }

        @Override
        public Object getItem(int position) {
            return icons[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=View.inflate(getActivity(),R.layout.layout,null);
            ImageView icon=(ImageView) convertView.findViewById(R.id.foodicon);
            icon.setBackgroundResource(icons[position]);
            TextView txtName=(TextView) convertView.findViewById(R.id.foodname);
            txtName.setText(foodNames[position]);
            return convertView;
        }
    }
}
