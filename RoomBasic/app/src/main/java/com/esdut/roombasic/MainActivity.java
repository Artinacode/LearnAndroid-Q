package com.esdut.roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordDataBase wordDataBase;
    TextView textView;
    WordDao wordDao;
    Button btn_insert,btn_query,btn_update,btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordDataBase = Room.databaseBuilder(this,WordDataBase.class,"word_databbase")
                .allowMainThreadQueries()
                .build();
        updateView();
        btn_insert = findViewById(R.id.btn_insert);
        btn_query = findViewById(R.id.btn_query);
        btn_delete = findViewById(R.id.btn_delete);
        btn_update = findViewById(R.id.btn_update);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("hello", "您好");
                Word word2 = new Word("word", "世界");
                wordDao.insertWords(word1,word2);
                updateView();

            }
        });
    }

    void updateView() {
        List<Word> list = wordDao.getAllWords();
        String text = null;

        for(int i=0;i<list.size();i++) {
            Word word = list.get(i);
            text += word.getId() + ":" + word.getWord() + "=" + word.getChineseMeaning();
        }
        textView.setText(text);
    }
}