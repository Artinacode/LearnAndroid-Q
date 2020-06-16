package com.esdut.calculationtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.esdut.calculationtest.databinding.FragmentLoseBinding;

public class LoseFragment extends Fragment {


    public LoseFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final MyViewModel myViewModel = new ViewModelProvider(
                requireActivity(),new SavedStateViewModelFactory(getActivity().getApplication(),this))
                .get(MyViewModel.class);
        final FragmentLoseBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_lose,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        binding.button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loseFragment_to_titleFragment);
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}