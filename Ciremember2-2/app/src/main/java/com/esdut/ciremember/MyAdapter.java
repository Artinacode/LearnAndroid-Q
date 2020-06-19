package com.esdut.ciremember;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ListAdapter<Word,MyAdapter.MyViewHolder> {
//    private List<Word> allWords =  new ArrayList<>();   //父类中已经有了ArrayList
    private final boolean useCardView;
    private WordViewModel wordViewModel;
    MyAdapter(boolean useCardView, WordViewModel wordViewModel) {
        super(new DiffUtil.ItemCallback<Word>() {
            @Override
            public boolean areItemsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Word oldItem, @NonNull Word newItem) {
                return (oldItem.getWord().equals(newItem.getWord())
                && oldItem.getChineseMeaning().equals(newItem.getChineseMeaning())
                        && oldItem.isChineseInvisiable() == oldItem.isChineseInvisiable());
            }
        });
        this.useCardView = useCardView;
        this.wordViewModel = wordViewModel;
    }

//    void setAllWords(List<Word> allWords) {
//        this.allWords = allWords;
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView;
        if (useCardView) {
              itemView = layoutInflater.inflate(R.layout.cell_card_2,parent,false);
        } else {
            itemView = layoutInflater.inflate(R.layout.cell_normal_2,parent,false);
        }
        final MyViewHolder holder = new MyViewHolder(itemView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = holder.textViewEnglish.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("word",u);
                intent.setAction("ask");
                intent.addCategory("android.intent.category.DEFAULT");
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.aSwitchChineseInvisiable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Word word = (Word) holder.itemView.getTag(R.id.word_for_view_holder);
                if (isChecked) {
                    //如果点击了  修改视图 修改底层数据
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
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
//        final Word word = allWords.get(position);//
        final Word word = getItem(position);
        holder.itemView.setTag(R.id.word_for_view_holder,word);
        holder.textViewNumber.setText(String.valueOf(position + 1));
        holder.textViewEnglish.setText(word.getWord());
        holder.textViewChinese.setText(word.getChineseMeaning());
//        // 先设置监听器为空
//        holder.aSwitchChineseInvisiable.setOnCheckedChangeListener(null);
        if(word.isChineseInvisiable()) {
            holder.textViewChinese.setVisibility(View.GONE);
            holder.aSwitchChineseInvisiable.setChecked(true);
        } else {
            holder.textViewChinese.setVisibility(View.VISIBLE);
            holder.aSwitchChineseInvisiable.setChecked(false);
        }
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
////                Uri uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=" + holder.textViewEnglish.getText());
////                Intent intent = new Intent(Intent.ACTION_VIEW);
////                intent.setData(uri);
////                holder.itemView.getContext().startActivity(intent);
//            }
//        });

//        holder.aSwitchChineseInvisiable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    //如果点击了  修改视图 修改底层数据  两件事
//                    holder.textViewChinese.setVisibility(View.GONE);
//                    word.setChineseInvisiable(true);
//                    wordViewModel.updateWords(word);
//                } else {
//                    holder.textViewChinese.setVisibility(View.VISIBLE);
//                    word.setChineseInvisiable(false);
//                    wordViewModel.updateWords(word);
//                }
//            }
//        });

    }

//    @Override
//    public int getItemCount() {
//        return allWords.size();
//    }


    @Override
    public void onViewAttachedToWindow(@NonNull MyViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.textViewNumber.setText(String.valueOf(holder.getAdapterPosition() + 1));
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
