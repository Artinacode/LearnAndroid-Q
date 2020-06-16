package com.esdut.listview;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    private AddSubView addSubView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        addSubView = (AddSubView) findViewById(R.id.add_sub_view);
        addSubView.setOnAddSubClickListener(new AddSubView.OnAddSubClickListener() {
            @Override
            public void onNumberChange(int value) {
                Toast.makeText(MainActivity5.this, "当前value===" + value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
