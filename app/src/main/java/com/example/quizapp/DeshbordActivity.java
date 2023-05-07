package com.example.quizapp;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import static com.example.quizapp.MainActivity.listOfQuestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.quizapp.model.QuestionModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DeshbordActivity extends AppCompatActivity {


    CountDownTimer countDownTimer;
    ProgressBar progressBar;
    ArrayList<QuestionModel> allQuestionList;
    QuestionModel questionModel;

    CardView cardView,cardView2,cardView3,cardView4,cardView5;
    TextView questionTV, ansOneTV,ansTwoTV,ansThreeTV,ansFourTV;
    Button nextBtn;
    int timer=20;
    int index=0;

    int correctCount=0;
    int wrongCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deshbord);



       viewBinding();

       allQuestionList=listOfQuestion;


        Log.d(TAG, "onCreate: "+allQuestionList.size());

        if (!allQuestionList.isEmpty()) {
            // shuffle allQuestionList
            Collections.shuffle(allQuestionList);
            // assign the first element to questionModel
            questionModel = allQuestionList.get(index);
            // set the question and answer options
            setAllQuestion();
        } else {
            // handle the case where allQuestionList is empty
            Log.d(TAG, "All questions have been answered.");
        }


        progressBar=findViewById(R.id.progressBar);
        startCounterTimer(20000);
    }

   public void startCounterTimer(long timere){
       countDownTimer=new CountDownTimer(timere,1000) {
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

    private void setAllQuestion() {



        questionTV.setText(questionModel.getQuestion());
        ansOneTV.setText(questionModel.getAnsOne());
        ansTwoTV.setText(questionModel.getAnsTwo());
        ansThreeTV.setText(questionModel.getAnsThree());
        ansFourTV.setText(questionModel.getAnsFour());

    }

    private void viewBinding() {
        cardView=findViewById(R.id.cardView);
        cardView2=findViewById(R.id.cardView2);
        cardView3=findViewById(R.id.cardView3);
        cardView4=findViewById(R.id.cardView4);
        cardView5=findViewById(R.id.cardView5);

        questionTV=findViewById(R.id.question_Tv);
        ansOneTV=findViewById(R.id.ans_one_Tv);
        ansTwoTV=findViewById(R.id.ans_two_Tv);
        ansThreeTV=findViewById(R.id.ans_three_Tv);
        ansFourTV=findViewById(R.id.ans_four_Tv);

        nextBtn=findViewById(R.id.next_btn);
    }
    public  void correct(CardView cardAnsView){
        Log.d(TAG, "correct: ");
        cardAnsView.setCardBackgroundColor(getResources().getColor(R.color.black));

        nextBtn.setOnClickListener(view -> {
            Log.d(TAG, "correct: 2");
            correctCount++;
            index++;
            questionModel = allQuestionList.get(index);
            setAllQuestion();
            resetBackColor();
            startCounterTimer(20000);
            timer=20;
            clickEnable();
        });

    }

    public  void  wrong(CardView wongAnsView){
        Log.d(TAG, "wrong: ");
        wongAnsView.setCardBackgroundColor(getResources().getColor(R.color.red));

  nextBtn.setOnClickListener(view -> {
      Log.d(TAG, "wrong:2 ");
      wrongCount++;
      if(index<allQuestionList.size()-1){
          Log.d(TAG, "wrong:3");
          index++;
          questionModel = allQuestionList.get(index);
          setAllQuestion();
          resetBackColor();
          startCounterTimer(20000);
          timer=20;
          clickEnable();
      }else {
          GameWon();
      }
  });

    }

    private void GameWon() {
        startActivity(new Intent(DeshbordActivity.this,GameWonActivity.class));

    }
    public void clickEnable(){
        cardView2.setClickable(true);
        cardView3.setClickable(true);
        cardView4.setClickable(true);
        cardView5.setClickable(true);
    }

    public void clickDisable(){
        cardView2.setClickable(false);
        cardView3.setClickable(false);
        cardView4.setClickable(false);
        ansFourTV.setClickable(false);
    }
    public  void resetBackColor(){
        cardView2.setBackgroundColor(getResources().getColor(R.color.white));
        cardView3.setBackgroundColor(getResources().getColor(R.color.white));
        cardView4.setBackgroundColor(getResources().getColor(R.color.white));
        cardView5.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void ansOneClick(View view) {

        if (questionModel.getAnsOne().equals(questionModel.getFinalAns())){
            cardView2.setCardBackgroundColor(getResources().getColor(R.color.black));
            if(index<allQuestionList.size()-1){
                correct(cardView2);

            }else {
                GameWon();
            }
        }else {
            wrong(cardView2);

        }
    }

    public void ansTwoClick(View view) {
        if (questionModel.getAnsTwo().equals(questionModel.getFinalAns())){
            cardView3.setCardBackgroundColor(getResources().getColor(R.color.black));
            if(index<allQuestionList.size()-1){
                correct(cardView3);
            }else {
                GameWon();
            }

        }else {
            wrong(cardView3);

        }
    }

    public void ansThreeClick(View view) {
        if (questionModel.getAnsThree().equals(questionModel.getFinalAns())){
            cardView4.setCardBackgroundColor(getResources().getColor(R.color.black));
            if(index<allQuestionList.size()-1){
                correct(cardView4);
            }else {
                GameWon();
            }

        }else {
            wrong(cardView4);

        }
    }

    public void ansFourClick(View view) {
        if (questionModel.getAnsFour().equals(questionModel.getFinalAns())){
            cardView5.setCardBackgroundColor(getResources().getColor(R.color.black));
            if(index<allQuestionList.size()-1){
               correct(cardView5);
            }else {
                GameWon();
            }

        }else {
            wrong(cardView5);

        }
    }
}