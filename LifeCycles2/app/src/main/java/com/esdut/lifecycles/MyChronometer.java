package com.esdut.lifecycles;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class MyChronometer extends Chronometer implements LifecycleEventObserver {
    private long elapsedTime;
    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pauseMeter() {
        elapsedTime = SystemClock.elapsedRealtime() - getBase();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resumeMeter(){
        setBase(SystemClock.elapsedRealtime() - elapsedTime);
        start();
    }

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
           
    }
}
