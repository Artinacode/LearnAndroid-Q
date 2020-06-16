package com.esdut.navviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//创建MyViewModel类，在类内定义LiveData
//定义数据操作的函数
public class MyViewModel extends ViewModel  {
    private MutableLiveData<Integer>number;

    public MutableLiveData<Integer>getNumber(){
        if(number == null){
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }
    public void add(int x) {
        number.setValue(number.getValue() + x);
        if(number.getValue() < 0) {
            number.setValue(0);
        }
    }
}
