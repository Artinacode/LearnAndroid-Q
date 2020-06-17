package com.esdut.ciremember;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {
    private TextView textViewUser,textViewPassword,welcome1,welcome2;
    private Button button;

    public LoginFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textViewUser = requireActivity().findViewById(R.id.userText);
        textViewPassword = requireActivity().findViewById(R.id.passwordText);
        button = requireActivity().findViewById(R.id.button);
        welcome1 = requireActivity().findViewById(R.id.welcome1);
        welcome2 = requireActivity().findViewById(R.id.welcome2);
        welcome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome1.setVisibility(View.INVISIBLE);
                welcome2.setVisibility(View.VISIBLE);
            }
        });
        welcome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome2.setVisibility(View.INVISIBLE);
                welcome1.setVisibility(View.VISIBLE);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aUser = textViewUser.getText().toString();
                String aPss = textViewPassword.getText().toString();
                if (aUser.equals("admin") && aPss.equals("123456")) {
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_loginFragment_to_wordsFragment);
                    Toast.makeText(requireActivity(),"登陆成功",Toast.LENGTH_SHORT).show();
                } else if (aUser.equals("root")){
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_loginFragment_to_wordsFragment);
                    Toast.makeText(requireActivity(),"进入管理员模式",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireActivity(),"账号或密码错误，请重新输入",Toast.LENGTH_LONG).show();
                    textViewPassword.setText("");
                }

            }
        });



    }
}