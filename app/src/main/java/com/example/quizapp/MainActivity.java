package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar=findViewById(R.id.progress_circular);


        new Handler().postDelayed(() -> {

            startActivity(new Intent(MainActivity.this,DeshbordActivity.class));

        },1500);
    }
}