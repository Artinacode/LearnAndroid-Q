package com.esdut.calculationtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    NavController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         controller = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this,controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (controller.getCurrentDestination().getId()  == R.id.titleFragment) {
            finish();
        }else  if (controller.getCurrentDestination().getId()  == R.id.questionFragment) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.quit_dialog_title));
            builder.setPositiveButton(R.string.dialog_positive_message, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    controller.navigateUp();
                }
            });
            builder.setNegativeButton(R.string.dialog_negative_message, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.create().show();
        } else {
            controller.navigate(R.id.titleFragment);
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
//        String TAG = "my_tag";
////        if (controller.getCurrentDestination().getId() == R.id.titleFragment) {
//////            super.onBackPressed();
//////            Log.d(TAG, "onBackPressed: onback");
//////        }  else {
////            onSupportNavigateUp();
////            Log.d(TAG, "onBackPressed: onsupport");
////            }
        onSupportNavigateUp();
        }


}