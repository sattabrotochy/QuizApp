package com.example.quizapp;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ProgressBar;

public class DeshbordActivity extends AppCompatActivity {


    CountDownTimer countDownTimer;
    ProgressBar progressBar;
    int timer=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deshbord);

        progressBar=findViewById(R.id.progressBar);
        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                timer=timer-1;
                progressBar.setProgress(timer);
            }

            @Override
            public void onFinish() {
                Log.d(TAG, "onFinish: done");
                Dialog dialog=new Dialog(DeshbordActivity.this,R.style.dialog);
                dialog.setContentView(R.layout.timer_dialog);
                dialog.show();

            }
        }.start();
    }
}