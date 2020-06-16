package com.esdut.calculationtest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.Random;

public class MyViewModel extends AndroidViewModel {
    private  SavedStateHandle handle;
    private  static String KEY_HIGH_SCORE = "key_high_score";
    private  static String KEY_CURRENT_SCORE = "key_current_score";
    private  static String KEY_LEFT_NUMBER = "key_left_number";
    private  static String KEY_RIGHT_NUMBER = "key_right_number";
    private  static String KEY_OPERATOR = "key_operator";
    private  static String KEY_ANSWER = "key_answer";
    private  static String SAVE_SHP_DATA_NAME  = "save_shp_data_name";
    boolean win_flag = false;
    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        if (!handle.contains(KEY_HIGH_SCORE)) {
            SharedPreferences shp = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME, Context.MODE_PRIVATE);
            handle.set(KEY_HIGH_SCORE,shp.getInt(KEY_HIGH_SCORE,0));
            handle.set(KEY_CURRENT_SCORE,0);
            handle.set(KEY_LEFT_NUMBER,0);
            handle.set(KEY_RIGHT_NUMBER,0);
            handle.set(KEY_OPERATOR,"+");
            handle.set(KEY_ANSWER,0);
        }
        this.handle = handle;
    }
    public MutableLiveData<Integer>getLeftNumber() {
        return handle.getLiveData(KEY_LEFT_NUMBER);
    }
    public MutableLiveData<Integer>getRightNumber() {
        return handle.getLiveData(KEY_RIGHT_NUMBER);
    }
    public MutableLiveData<String>getOperator() {
        return handle.getLiveData(KEY_OPERATOR);
    }
    public MutableLiveData<Integer>getHighScore() {
        return handle.getLiveData(KEY_HIGH_SCORE);
    }
    public MutableLiveData<Integer>getCurrentScore() {
        return handle.getLiveData(KEY_CURRENT_SCORE);
    }
    public MutableLiveData<Integer>getAnswer() {
        return handle.getLiveData(KEY_ANSWER);
    }

    public void generator() {

        int LEVEL = 20;
        int op_num = 4;
        Random random = new Random();
        // 0 ----level-1 随机数范围
        int x ,y,z;
        x = random.nextInt(LEVEL) + 1;
        y = random.nextInt(LEVEL) + 1;

        z = random.nextInt(4) + 1;
        switch(z){
            case 1:
                getOperator().setValue("+");
                getRightNumber().setValue(y);
                getLeftNumber().setValue(x);
//                getAnswer().setValue(getLeftNumber().getValue() + getRightNumber().getValue());
                getAnswer().setValue(getLeftNumber().getValue() + getRightNumber().getValue());
                break;
            case 2:
                getOperator().setValue("-");
                if (x > y) {
                    getLeftNumber().setValue(x);
                    getRightNumber().setValue(y);
                } else {
                    getLeftNumber().setValue(y);
                    getRightNumber().setValue(x);
                }
//                getAnswer().setValue(getLeftNumber().getValue() + getRightNumber().getValue());
                getAnswer().setValue(getLeftNumber().getValue() - getRightNumber().getValue());
                break;
            case 3:
                getOperator().setValue("*");
                getRightNumber().setValue(y);
                getLeftNumber().setValue(x);
//                getAnswer().setValue(getLeftNumber().getValue() + getRightNumber().getValue());
                getAnswer().setValue(getLeftNumber().getValue() * getRightNumber().getValue());
                break;
            case 4:
                getOperator().setValue("/");
                getLeftNumber().setValue((x/2+1)*(y/2+1));
                getRightNumber().setValue(x/2+1);
                getAnswer().setValue(getLeftNumber().getValue() / getRightNumber().getValue());
//                getAnswer().setValue(y/2);
                break;
        }
    }
    @SuppressWarnings("ConstantConditions")
    public void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =shp.edit();
        editor.putInt(KEY_HIGH_SCORE,getHighScore().getValue());
        editor.apply();
    }

    @SuppressWarnings("ConstantConditions")
    public void answerCorrect() {
        getCurrentScore().setValue(getCurrentScore().getValue() + 1 );
        if(getCurrentScore().getValue() > getHighScore().getValue()) {
            getHighScore().setValue(getCurrentScore().getValue());
            win_flag = true;
        }
        generator();
    }
    public void get_begin_score() {
        getCurrentScore().setValue( 0 );
    }
}
