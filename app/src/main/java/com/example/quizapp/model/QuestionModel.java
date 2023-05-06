package com.example.quizapp.model;

public class QuestionModel {
    String question;
    String ansOne;
    String ansTwo;
    String ansThree;
    String ansFour;
    String finalAns;

    public QuestionModel(String question, String ansOne, String ansTwo, String ansThree, String ansFour, String finalAns) {
        this.question = question;
        this.ansOne = ansOne;
        this.ansTwo = ansTwo;
        this.ansThree = ansThree;
        this.ansFour = ansFour;
        this.finalAns = finalAns;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnsOne() {
        return ansOne;
    }

    public void setAnsOne(String ansOne) {
        this.ansOne = ansOne;
    }

    public String getAnsTwo() {
        return ansTwo;
    }

    public void setAnsTwo(String ansTwo) {
        this.ansTwo = ansTwo;
    }

    public String getAnsThree() {
        return ansThree;
    }

    public void setAnsThree(String ansThree) {
        this.ansThree = ansThree;
    }

    public String getAnsFour() {
        return ansFour;
    }

    public void setAnsFour(String ansFour) {
        this.ansFour = ansFour;
    }

    public String getFinalAns() {
        return finalAns;
    }

    public void setFinalAns(String finalAns) {
        this.finalAns = finalAns;
    }
}
