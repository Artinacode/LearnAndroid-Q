package com.esdut.navviewmodel;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esdut.navviewmodel.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    MyViewModel myViewModel ;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        FragmentDetailBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_detailFragment_to_masterFragment);
            }
        });
        return binding.getRoot();
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail, container, false);

    }
}