package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.quizapp.model.QuestionModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


   public static ArrayList<QuestionModel> listOfQuestion;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfQuestion = new ArrayList<>();

        listOfQuestion.add(new QuestionModel(
                "Which planet is closest to the sun?",
                "Mercury", "Venus", "Earth", "Mars", "Mercury"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the largest country in the world?",
                "Russia", "Canada", "China", "United States", "Russia"
        ));

        listOfQuestion.add(new QuestionModel(
                "Who invented the telephone?",
                "Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "Albert Einstein", "Alexander Graham Bell"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the chemical symbol for gold?",
                "Au", "Ag", "Fe", "Cu", "Au"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the largest organ in the human body?",
                "Skin", "Heart", "Brain", "Liver", "Skin"
        ));
        listOfQuestion.add(new QuestionModel(
                "Who wrote the novel 'Pride and Prejudice'?",
                "Jane Austen", "William Shakespeare", "Charles Dickens", "George Orwell", "Jane Austen"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the smallest ocean in the world?",
                "Arctic", "Atlantic", "Indian", "Pacific", "Arctic"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the currency of Japan?",
                "Yen", "Dollar", "Euro", "Pound", "Yen"
        ));

        listOfQuestion.add(new QuestionModel(
                "Which country won the FIFA World Cup in 2018?",
                "France", "Brazil", "Germany", "Spain", "France"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the name of the famous clock tower in London?",
                "Big Ben", "Eiffel Tower", "Statue of Liberty", "Sydney Opera House", "Big Ben"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the largest mammal in the world?",
                "Blue Whale", "Elephant", "Giraffe", "Hippopotamus", "Blue Whale"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the largest organ in the human body?",
                "Skin", "Heart", "Brain", "Liver", "Skin"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the only continent that is also a country?",
                "Australia", "South America", "Africa", "Europe", "Australia"
        ));

        listOfQuestion.add(new QuestionModel(
                "Who played the character Harry Potter in the film series?",
                "Daniel Radcliffe", "Rupert Grint", "Emma Watson", "Tom Felton", "Daniel Radcliffe"
        ));

        listOfQuestion.add(new QuestionModel(
                "What is the chemical symbol for oxygen?",
                "O", "H", "C", "N", "O"
        ));


        progressBar = findViewById(R.id.progress_circular);


        new Handler().postDelayed(() -> {

            startActivity(new Intent(MainActivity.this, DeshbordActivity.class));

        }, 1500);
    }
}