package com.moyu.databinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 *
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;
    public MutableLiveData<Integer> getNumber(){
        if(number == null){
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void add() {
        number.setValue(number.getValue() + 1);
    }
}
