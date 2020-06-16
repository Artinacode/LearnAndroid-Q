package com.esdut.calculationtest;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esdut.calculationtest.databinding.FragmentTitleBinding;

import static android.content.ContentValues.TAG;


public class TitleFragment extends Fragment {


    public TitleFragment() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MyViewModel myViewModel = new ViewModelProvider(
                requireActivity(),new SavedStateViewModelFactory(getActivity().getApplication(),this))
                .get(MyViewModel.class);
        // 这里跟文件名很像  注意一下 文件名的逆转过来
        FragmentTitleBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

//        myViewModel.get_begin_score();
        String TAG = "123";
        Log.d(TAG, "onCreateView: "+ myViewModel.getHighScore().getValue().intValue());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.get_begin_score();
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_titleFragment_to_questionFragment);
            }
        });
        return binding.getRoot();
    }
}