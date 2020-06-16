package com.esdut.calculationtest;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esdut.calculationtest.databinding.FragmentQuestionBinding;
import com.esdut.calculationtest.databinding.FragmentWinBinding;


public class WinFragment extends Fragment {


    public WinFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final MyViewModel myViewModel = new ViewModelProvider(
                requireActivity(),new SavedStateViewModelFactory(getActivity().getApplication(),this))
                .get(MyViewModel.class);
        final FragmentWinBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_win,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_winFragment_to_titleFragment);
            }
        });
        return binding.getRoot();
    }
}