package com.esdut.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] titles = {"菠萝","蓝莓","蜜瓜","蜜桃","苹果",
            "枇杷"};
    private String[] prices = {"10元","20元","30元","40元","50元",
            "60元"};
    private int[] icons = {R.drawable.fl,R.drawable.lm,R.drawable.mg,
            R.drawable.mt,R.drawable.pg,R.drawable.pp};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lv);
        MyBaseAdapter adapter = new MyBaseAdapter();
        listView.setAdapter(adapter);
    }

    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {     //获取item总数
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            //将XML文件转换为view对象
//            View view = View.inflate(MainActivity.this,R.layout.list_item,null);
//            //初始化view对象中的控件
//            TextView title = view.findViewById(R.id.title);
//            TextView price = view.findViewById(R.id.price);
//            ImageView iv = view.findViewById(R.id.iv);
//            title.setText(titles[position]);
//            price.setText(prices[position]);
//            iv.setImageResource(icons[position]);
//            return view;
            ViewHolder holder;
            if(convertView == null){
                convertView = View.inflate(MainActivity.this,R.layout.list_item,null);
                holder = new ViewHolder();
                holder.title = convertView.findViewById(R.id.title);
                holder.price = convertView.findViewById(R.id.price);
                holder.iv = convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(titles[position]);
            holder.price.setText(prices[position]);
            holder.iv.setImageResource(icons[position]);
            return convertView;

        }
    }
    class ViewHolder{
        TextView title;
        TextView price;
        ImageView iv;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                {
//                    Intent intent = new Intent(this,MainActivity2.class);
                    Intent intent = new Intent("22222");
                    startActivity(intent);
                }

                break;
            case R.id.shop_item:
            {
                Intent intent = new Intent("shop");
                startActivity(intent);
            }
            break;
            case R.id.remove_item:
                Toast.makeText(this,"remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}