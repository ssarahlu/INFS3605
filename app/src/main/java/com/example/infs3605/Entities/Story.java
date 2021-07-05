package com.example.infs3605.Entities;

import java.util.ArrayList;
import com.example.infs3605.R;

public class Story {
    private int storyId;
    private String information;
    private int image;
    private int moduleId;

    public Story (){

    }

    public Story(int storyId, String information, int image, int moduleId) {
        this.storyId = storyId;
        this.information = information;
        this.image = image;
        this.moduleId = moduleId;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
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
    public static ArrayList<Story> getStory() {
        ArrayList<Story> story = new ArrayList<>();

        story.add(new Story (1, "Long ago in the Dreamtime when the earth lay sleeping and nothing moved or grew, lived the Rainbow Serpent. Then one day the Rainbow Serpent awoke and come out from beneath the earth. Refreshed from her long slumber she travelled far and wide leaving winding tracks from her huge body and then returning to the place she had first appeared. \n On her return she called to the frogs \"come out!\" The frogs came out slowly as their bellies were full with water which they had stored during their long sleep. The Rainbow Serpent tickled their stomachs and when the frogs laughed, the water spilled out all over the earth to fill the tracks of the Rainbow Serpent. This is how the lakes and the rivers were first formed.\n" +
                "\n With water, grass and trees began to grow which woke all the animals who then followed the Rainbow Serpent across the land. They were happy on earth and each lived and gathered food with their own tribe. Some animals lived in rocks, some on the vast plains, and others in trees and in the sky. The Rainbow Serpent made laws that they were all to obey but some began to make trouble and argue. The Rainbow Serpent said \"Those who keep my laws will be rewarded; I will give them human form. Those who break my laws will be punished and turned to stone & will never to walk the earth again\". Those who broke the law became stone and were turned into mountains and hills and those who were obedient were turned into human form and were each given their own totem of the animal, bird or reptile from when they began. The tribes knew themselves by their totems - kangaroo, emu, carpet snake, and many, many more. So no one would starve, the Rainbow Serpent ruled that no man should eat of his totem, but only of other totems. This way there was food for everyone.\n" +
                "\n The tribes lived together on the land given to them by the Rainbow Serpent or Mother of Life and knew the land would always be theirs, and no one should ever take it from them.\n" +
                "\n ", R.drawable.rainbow_serpent_1, 1));



        return story;
    }



    }
