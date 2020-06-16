package com.esdut.roombasic1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    WordDataBase wordDataBase;
    TextView textView;
//    WordDao wordDao;
    Button btn_insert,btn_clear,btn_update,btn_delete;
//    LiveData<List<Word>>allWordsLive;
    WordViewModel wordViewModel;
    RecyclerView recyclerView;
    MyAdapter myAdapter1,myAdapter2;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        recyclerView = findViewById(R.id.recycleView);
        myAdapter1 = new MyAdapter(false,wordViewModel);
        myAdapter2 = new MyAdapter(true,wordViewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter1);
        aSwitch = findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    recyclerView.setAdapter(myAdapter2);
                } else {
                    recyclerView.setAdapter(myAdapter1);
                }
            }
        });

        wordViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                int temp = myAdapter1.getItemCount();
                myAdapter1.setAllWords(words);
                myAdapter2.setAllWords(words);
                if (temp != words.size()) {
                    myAdapter1.notifyDataSetChanged();
                    myAdapter2.notifyDataSetChanged();
                }

            }
        });
        btn_insert = findViewById(R.id.btn_insert);

        btn_clear = findViewById(R.id.btn_clear);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] english = {
                        "Hello",
                        "World",
                        "Android",
                        "Google",
                        "Studio",
                        "Project",
                        "Database",
                        "Recycler",
                        "View",
                        "String",
                        "Value",
                        "Integer"
                };
                String[] chinese = {
                        "你好",
                        "世界",
                        "安卓系统",
                        "谷歌公司",
                        "工作室",
                        "项目",
                        "数据库",
                        "回收站",
                        "视图",
                        "字符串",
                        "价值",
                        "整数类型"
                };
                for(int i = 0;i<english.length;i++) {
                    wordViewModel.insertWords(new Word(english[i],chinese[i]));
                }
//                Word word1 = new Word("hello", "您好");
//                Word word2 = new Word("word", "世界");
////                wordDao.insertWords(word1,word2);
////                new InsertAsynTask(wordDao).execute(word1,word2);
//                wordViewModel.insertWords(word1,word2);
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new DeleteAllAsynTask(wordDao).execute();
                wordViewModel.clearWords();
            }
        });

//        btn_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Word word = new Word("Hi","你好啊");
//                word.setId(40);
////                wordDao.updataWords(word);
////                new UpdateAsynTask(wordDao).execute(word);
//                wordViewModel.updateWords(word);
//            }
//        });
//        btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Word word = new Word("Hi","你好啊");
//                word.setId(40);
////                wordDao.deleteWords(word);
////                new WordViewModel.DeleteAsynTask(wordDao).execute(word);
//                wordViewModel.deleteWords(word);
//            }
//        });
    }

//    void updateView() {
//    已经被Livedata替换
//    }

    //

}