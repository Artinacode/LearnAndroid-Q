package com.esdut.roombasic1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Word> allWords =  new ArrayList<>();
    private final boolean useCardView;
    private WordViewModel wordViewModel;
    MyAdapter(boolean useCardView, WordViewModel wordViewModel) {
        this.useCardView = useCardView;
        this.wordViewModel = wordViewModel;
    }

    void setAllWords(List<Word> allWords) {
        this.allWords = allWords;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemVIew;
        if (useCardView) {
              itemVIew = layoutInflater.inflate(R.layout.cell_card_2,parent,false);
        } else {
            itemVIew = layoutInflater.inflate(R.layout.cell_normal_2,parent,false);
        }

        return new MyViewHolder(itemVIew);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Word word = allWords.get(position);
        holder.textViewNumber.setText(String.valueOf(position + 1));
        holder.textViewEnglish.setText(word.getWord());
        holder.textViewChinese.setText(word.getChineseMeaning());
        /**
         * 先设置监听器为空
         */
        holder.aSwitchChineseInvisiable.setOnCheckedChangeListener(null);
        if(word.isChineseInvisiable()) {
            holder.textViewChinese.setVisibility(View.GONE);
            holder.aSwitchChineseInvisiable.setChecked(true);
        } else {
            holder.textViewChinese.setVisibility(View.VISIBLE);
            holder.aSwitchChineseInvisiable.setChecked(false);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = holder.textViewEnglish.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("word",u);
                intent.setAction("ask");
                intent.addCategory("android.intent.category.DEFAULT");
                holder.itemView.getContext().startActivity(intent);

//                Uri uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=" + holder.textViewEnglish.getText());
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(uri);
//                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.aSwitchChineseInvisiable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //如果点击了  修改视图 修改底层数据  两件事
                    holder.textViewChinese.setVisibility(View.GONE);
                    word.setChineseInvisiable(true);
                    wordViewModel.updateWords(word);
                } else {
                    holder.textViewChinese.setVisibility(View.VISIBLE);
                    word.setChineseInvisiable(false);
                    wordViewModel.updateWords(word);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return allWords.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNumber, textViewEnglish,textViewChinese;
        Switch aSwitchChineseInvisiable;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNumber = itemView.findViewById(R.id.textViewNumber);
            textViewEnglish =itemView.findViewById(R.id.textViewEnglish);
            textViewChinese = itemView.findViewById(R.id.textViewChinese);
            aSwitchChineseInvisiable = itemView.findViewById(R.id.CI);
        }
    }
}
