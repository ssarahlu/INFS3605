package com.example.infs3605.Entities;

import java.util.ArrayList;

public class Facts {

    private int factId;
    private String fact;

    public Facts (){

    }

    public Facts(int factId, String fact) {
        this.factId = factId;
        this.fact = fact;
    }

    public int getFactId() {
        return factId;
    }

    public void setFactId(int factId) {
        this.factId = factId;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    //dummy data - change once BAs have got proper data
    public static ArrayList<Facts> getFacts(){

        ArrayList<Facts> facts = new ArrayList<>();

        facts.add(new Facts (1, "Aboriginal Australians could be the oldest population of humans living outside of Africa, where one theory says they migrated from in boats 70,000 years ago."));
        facts.add(new Facts (2, "The earliest Indigenous art was paintings or engravings on the walls of rock shelters and caves which is called rock art."));
        facts.add(new Facts (3, "The Aboriginal Flag was designed in the 1970s and its colours represent different aspects of Aboriginal life. The black symbolises Aboriginal people, the yellow represents the sun and the red represents the earth and the relationship between people and the land."));
        facts.add(new Facts (4, "The Dreamtime (or the Dreaming) is a general term used to describe the complex network of Aboriginal spiritual beliefs, creation and existence on earth."));
        facts.add(new Facts(5, "Aboriginal and Torres Strait Islander art is among the oldest forms of art in the world. Like the different languages unique to different cultures, First Nations art has a different meaning for different groups. Colours and styles differ from one nation to another, as do the messages in the stories."));


        return facts;
    }





}
