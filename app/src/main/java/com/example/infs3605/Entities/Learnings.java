package com.example.infs3605.Entities;

import java.util.ArrayList;

import com.example.infs3605.R;

public class Learnings {
    private int learningId;
    private String information;
    private String image;
    private int moduleId;

    public Learnings(){

    }

    public Learnings(int learningId, String information, String image, int moduleId) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

        learnings.add(new Learnings(0, "It has life-giving powers that send conception (fertility) spirits to all the watercourses, such as billabongs, rivers, creeks and lagoons as it is in control of producing rainfall.", "https://www.kullillaart.com.au/assets/images/image12.jpg", 0));
        learnings.add(new Learnings(1, "The Rainbow Serpent is the protector of the land, its people, and the source of all life.", "https://www.kullillaart.com.au/assets/images/image12.jpg", 0 ));
        learnings.add(new Learnings(2, "Aboriginals in the Kimberley regions believe that the Rainbow Serpent places spirit-children throughout waterholes in which women will become impregnated if they wade in the water.", "https://www.kullillaart.com.au/assets/images/image12.jpg", 0 ));

        return learnings;


    }


    }
