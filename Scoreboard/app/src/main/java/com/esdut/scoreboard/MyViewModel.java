package com.esdut.scoreboard;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel  {
    private static final String TAG = "my_tag";
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private  int aBack;
    private  int bBack;


    public MutableLiveData<Integer> getaTeamScore() {
        if(aTeamScore == null) {
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if( bTeamScore == null) {
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }

    private void sycnBack() {
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
    }
    private void reBack() {
        aTeamScore.setValue(aBack);
        bTeamScore.setValue(bBack);
    }

    public void aTeamAdd(int p) {
        sycnBack();
        aTeamScore.setValue(aTeamScore.getValue() + p);
        Log.d(TAG, "aTeamAdd: " + p + getaTeamScore().getValue().toString());
    }
    public void bTeamAdd(int p) {
        sycnBack();
        bTeamScore.setValue(bTeamScore.getValue() + p);
    }

    public void reset() {
        sycnBack();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

    public void undo() {
        reBack();
    }
}
