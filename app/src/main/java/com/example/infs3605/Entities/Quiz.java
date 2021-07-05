package com.example.infs3605.Entities;

import java.util.ArrayList;

public class Quiz {
    private int id;
    private String question;
    private String op1, op2, op3, op4, answer;
    private int moduleId;

    public Quiz (){

    }

    public Quiz(int id, String question, String op1, String op2, String op3, String op4, String answer, int moduleId) {
        this.id = id;
        this.question = question;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.answer = answer;
        this.moduleId = moduleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public static ArrayList<Quiz> getQuiz() {
        ArrayList<Quiz> quiz = new ArrayList<>();
        quiz.add(new Quiz(0, "What is the rainbow serpent about?", "A rainbow serpent", "A black snake", "A green snake", "A koala", "A rainbow serpent", 0));
        quiz.add(new Quiz(1, "Is the rainbow serpent a dreamtime story?", "No it's a myth", "Yes it's a dreamtime story", "No it's not real", "No it's fake", "Yes it's a dreamtime story", 0));
        quiz.add(new Quiz(2, "Which values does the rainbow serpent teach?", "No values", "Lying is okay", "Peace and unity", "All the values", "Peace and unity", 0));

        return quiz;
    }






    }
