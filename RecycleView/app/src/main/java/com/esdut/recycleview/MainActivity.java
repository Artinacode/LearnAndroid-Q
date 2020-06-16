package com.esdut.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] names = {"张三","李四","王五","史密斯","史蒂斯"};
    private int[] icons = {R.drawable.tx1,R.drawable.tx2,R.drawable.tx3,R.drawable.tx4,
            R.drawable.tx5};
    private String[] introduces = {
            "15863640521",
            "15863645626",
            "13764640522",
            "15863467529",
            "15456567971"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HomeAdapter homeAdapter = new HomeAdapter();
        recyclerView.setAdapter(homeAdapter);
    }
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyviewHolder>{
        @NonNull
        @Override
        public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.recycle_item,parent,false);
            MyviewHolder myviewHolder = new MyviewHolder(view);
            return myviewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
            holder.name.setText(names[position]);
            holder.iv.setImageResource(icons[position]);
            holder.introduce.setText(introduces[position]);
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        class MyviewHolder extends RecyclerView.ViewHolder{
            TextView name;
            TextView introduce;
            ImageView iv;
            public MyviewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                introduce = itemView.findViewById(R.id.introduce);
                iv = itemView.findViewById(R.id.iv);
            }
        }
    }

}