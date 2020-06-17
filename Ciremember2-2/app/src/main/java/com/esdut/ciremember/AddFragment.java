package com.esdut.ciremember;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddFragment extends Fragment {
    private Button buttonSubmit;
    private EditText editTextEnglish,editTextChinese;
    private WordViewModel wordViewModel;

    public AddFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wordViewModel = new ViewModelProvider(getActivity()).get(WordViewModel.class);

        buttonSubmit = requireActivity().findViewById(R.id.buttonSummit);
        editTextEnglish = requireActivity().findViewById(R.id.edit1);
        editTextChinese = requireActivity().findViewById(R.id.edit2);
        buttonSubmit.setEnabled(false);
        editTextEnglish.requestFocus();
        InputMethodManager imn = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imn.showSoftInput(editTextEnglish,0);

        //监听器   监听内容变化
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String english = editTextEnglish.getText().toString().trim();
                String chinese = editTextEnglish.getText().toString().trim();
                buttonSubmit.setEnabled(!english.isEmpty() && !chinese.isEmpty()) ;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        //设置监听器
        editTextEnglish.addTextChangedListener(textWatcher);
        editTextChinese.addTextChangedListener(textWatcher);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String english = editTextEnglish.getText().toString().trim();
                String chinese = editTextChinese.getText().toString().trim();
                Word word = new Word(english,chinese);
                wordViewModel.insertWords(word);
                NavController navController = Navigation.findNavController(v);
                navController.navigateUp();
                InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
            }
        });


    }
}