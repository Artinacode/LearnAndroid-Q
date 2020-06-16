package com.esdut.navdemo2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 数据的传递
 *
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //连接xml控件
                EditText editText = getView().findViewById(R.id.editTextTextPersonName);
                //定义要传递的String数据变量并获取赋值
                String string = editText.getText().toString();
                //判断是否为空
                if(TextUtils.isEmpty(string)) {
                    //若为空,弹出吐司消息,返回return
                    Toast.makeText(getActivity(),"请输入名字",Toast.LENGTH_LONG).show();
                    return;
                }
                //定义bundle
                Bundle bundle = new Bundle();
                //bundle装载数据
                bundle.putString("my_name",string);
                //创建控制器
                NavController controller = Navigation.findNavController(v);
                //填写fragment也可以导航
                //控制器发射,(目标or动作路径,bundle数据)
                controller.navigate(R.id.action_homeFragment_to_detailFragment,bundle);
            }
        });
    }
}
