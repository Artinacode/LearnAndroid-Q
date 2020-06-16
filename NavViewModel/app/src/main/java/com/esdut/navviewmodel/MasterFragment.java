package com.esdut.navviewmodel;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.esdut.navviewmodel.databinding.FragmentDetailBinding;
import com.esdut.navviewmodel.databinding.FragmentMasterBinding;

/**
 * 定义主页面Fgment
 * //在匿名内部类中调用需要加final修饰符
 *
 * 1.创建myViewModel对象
 * 2.关联viewmodel和activity
 * 3.创建碎片binding类对象
 * 4.binding XML
 * 5.binding 数据源
 * 6.binding 观察者
 *
 *
 */
public class MasterFragment extends Fragment {


    public MasterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //在匿名内部类中调用需要加final修饰符
        final MyViewModel myViewModel;

        myViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        FragmentMasterBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_master,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_masterFragment_to_detailFragment);
            }
        });
        binding.seekBar.setProgress(myViewModel.getNumber().getValue());

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myViewModel.getNumber().setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return binding.getRoot();
    }
}