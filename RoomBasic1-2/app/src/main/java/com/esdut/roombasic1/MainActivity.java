package com.esdut.roombasic1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    WordDataBase wordDataBase;
    TextView textView;
//    WordDao wordDao;
    Button btn_insert,btn_clear,btn_update,btn_delete;
//    LiveData<List<Word>>allWordsLive;
    WordViewModel wordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
//        wordDataBase = Room.databaseBuilder(this,WordDataBase.class,"word_databbase")
//                .allowMainThreadQueries()
//                .build();
//        wordDao = wordDataBase.getWordDao();
//        allWordsLive = wordDao.getAllWordsLive();
        textView = findViewById(R.id.textView3);

        wordViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for(int i=0;i<words.size();i++) {
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append("=").append(word.getChineseMeaning()).append("\n");
                }
                textView.setText(text.toString());
            }
        });
        btn_insert = findViewById(R.id.btn_insert);
        btn_delete = findViewById(R.id.btn_delete);
        btn_clear = findViewById(R.id.btn_clear);
        btn_update = findViewById(R.id.btn_update);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("hello", "您好");
                Word word2 = new Word("word", "世界");
//                wordDao.insertWords(word1,word2);
//                new InsertAsynTask(wordDao).execute(word1,word2);
                wordViewModel.insertWords(word1,word2);
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new DeleteAllAsynTask(wordDao).execute();
                wordViewModel.clearWords();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi","你好啊");
                word.setId(40);
//                wordDao.updataWords(word);
//                new UpdateAsynTask(wordDao).execute(word);
                wordViewModel.updateWords(word);
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi","你好啊");
                word.setId(40);
//                wordDao.deleteWords(word);
//                new WordViewModel.DeleteAsynTask(wordDao).execute(word);
                wordViewModel.deleteWords(word);
            }
        });
    }

//    void updateView() {
//    已经被Livedata替换
//    }

    //

}