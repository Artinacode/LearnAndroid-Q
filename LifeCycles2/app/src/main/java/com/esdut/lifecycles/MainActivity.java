package com.esdut.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
//stop() 只能停止视图刷新 不能影响时间的停留
public class MainActivity extends AppCompatActivity {
    MyChronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.meter);
        getLifecycle().addObserver(chronometer);
//        chronometer.setBase(System.currentTimeMillis()); //UNIX 时间  1970 1-1 到现在为止的毫秒数
//        chronometer.setBase(SystemClock.elapsedRealtime());//手机从上一次开机到现在, 只跟系统启动有关
        //不写的话系统自动帮写SystemClock.elapsedRealtime()
        chronometer.start();
    }


}