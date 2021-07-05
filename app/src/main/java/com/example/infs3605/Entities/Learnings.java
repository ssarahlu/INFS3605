package com.example.infs3605.Entities;

import java.util.ArrayList;

import com.example.infs3605.R;

public class Learnings {
    private int learningId;
    private String information;
    private int image;
    private int moduleId;

    public Learnings(){

    }

    public Learnings(int learningId, String information, int image, int moduleId) {
        this.learningId = learningId;
        this.information = information;
        this.image = image;
        this.moduleId = moduleId;
    }

    public int getLearningId() {
        return learningId;
    }

    public void setLearningId(int learningId) {
        this.learningId = learningId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }


    //dummy data
    public static ArrayList<Learnings> getLearnings() {
        ArrayList<Learnings> learnings = new ArrayList<>();

        learnings.add(new Learnings(1, "It has life-giving powers that send conception (fertility) spirits to all the watercourses, such as billabongs, rivers, creeks and lagoons as it is in control of producing rainfall.", R.drawable.rainbow_serpent_1, 1));
        learnings.add(new Learnings(2, "The Rainbow Serpent is the protector of the land, its people, and the source of all life.", R.drawable.rainbow_serpent_1, 1 ));
        learnings.add(new Learnings(3, "Aboriginals in the Kimberley regions believe that the Rainbow Serpent places spirit-children throughout waterholes in which women will become impregnated if they wade in the water.", R.drawable.rainbow_serpent_1, 1 ));

        return learnings;


    }


    }
