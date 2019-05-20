package com.jinke.path;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;
    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final PathView pathView = findViewById(R.id.pathView);
        //模拟实时数据
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Log.i("BLE", "11111111111111111");
                pathView.setData(-100);
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerTask.cancel();
        timer.cancel();
        timerTask = null;
        timer = null;
    }
}
