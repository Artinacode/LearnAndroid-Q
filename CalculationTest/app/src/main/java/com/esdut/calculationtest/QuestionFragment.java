package com.esdut.calculationtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.esdut.calculationtest.databinding.FragmentQuestionBinding;
import com.esdut.calculationtest.databinding.FragmentQuestionBindingImpl;


public class QuestionFragment extends Fragment {

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MyViewModel myViewModel = new ViewModelProvider(
                requireActivity(), new SavedStateViewModelFactory(getActivity().getApplication(), this))
                .get(MyViewModel.class);

        myViewModel.generator();

        final FragmentQuestionBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        final StringBuilder builder = new StringBuilder();
        Log.d("123", "onCreateView: 我启动了");
        View.OnClickListener listener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button0:
                        builder.append("0");
                        break;
                    case R.id.button1:
                        builder.append("1");
                        break;
                    case R.id.button2:
                        builder.append("2");
                        break;
                    case R.id.button3:
                        builder.append("3");
                        break;
                    case R.id.button4:
                        builder.append("4");
                        break;
                    case R.id.button5:
                        builder.append("5");
                        break;
                    case R.id.button6:
                        builder.append("6");
                        break;
                    case R.id.button7:
                        builder.append("7");
                        break;
                    case R.id.button8:
                        builder.append("8");
                        break;
                    case R.id.button9:
                        builder.append("9");
                        break;
                    case R.id.buttonClear:
                        builder.setLength(0);
                        break;
                    //append(v.get().get text())
                }
                if (builder.length() == 0) {
                    binding.textView13.setText(getString(R.string.input_indicator));
                } else {
                    binding.textView13.setText(builder.toString());
                }
            }
        };

        binding.button0.setOnClickListener(listener);
        binding.button1.setOnClickListener(listener);
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.button5.setOnClickListener(listener);
        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);
        binding.buttonClear.setOnClickListener(listener);

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void onClick(View v) {
                if (builder.length() > 8) {
                    binding.textView13.setText("input again");
                    builder.setLength(0);
                    Toast.makeText(getContext(), "No more than Eight-digit", Toast.LENGTH_LONG).show();
                } else if (builder.length() == 0) {

                } else {
                    if (Integer.valueOf(builder.toString()).intValue() == myViewModel.getAnswer().getValue()) {
                        myViewModel.answerCorrect();
                        builder.setLength(0);
                        binding.textView13.setText(R.string.answer_correct_message);
//                    builder.append(R.string.answer_correct_message);
                    } else {
                        NavController controller = Navigation.findNavController(v);

                        if (myViewModel.win_flag) {
                            controller.navigate(R.id.action_questionFragment_to_winFragment);
                            myViewModel.win_flag = false;
                            myViewModel.save();
                        } else {
                            controller.navigate(R.id.action_questionFragment_to_loseFragment);
                        }
                    }
                }
//                if (Integer.valueOf(builder.toString()).intValue() == myViewModel.getAnswer().getValue()) {

            }
        });
        return binding.getRoot();
    }
}

/**
 * 模板
 */
//
//    public QuestionFragment() {
//        // Required empty public constructor
//    }
//
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_question, container, false);
//    }
//}