package com.example.infs3605.Entities;

import java.util.ArrayList;
import com.example.infs3605.R;

public class Story {
    private int storyId;
    private String information;
    private String image;
    private int moduleId;

    public Story (){

    }

    public Story(int storyId, String information, String image, int moduleId) {
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
    public static ArrayList<Story> getStory() {
        ArrayList<Story> story = new ArrayList<>();

        story.add(new Story (0, "Long ago in the Dreamtime when the earth lay sleeping and nothing moved or grew, lived the Rainbow Serpent. Then one day the Rainbow Serpent awoke and come out from beneath the earth. Refreshed from her long slumber she travelled far and wide leaving winding tracks from her huge body and then returning to the place she had first appeared. \n \nOn her return she called to the frogs \"come out!\" The frogs came out slowly as their bellies were full with water which they had stored during their long sleep. The Rainbow Serpent tickled their stomachs and when the frogs laughed, the water spilled out all over the earth to fill the tracks of the Rainbow Serpent. This is how the lakes and the rivers were first formed.\n" +
                "\nWith water, grass and trees began to grow which woke all the animals who then followed the Rainbow Serpent across the land. They were happy on earth and each lived and gathered food with their own tribe. Some animals lived in rocks, some on the vast plains, and others in trees and in the sky. The Rainbow Serpent made laws that they were all to obey but some began to make trouble and argue. The Rainbow Serpent said \"Those who keep my laws will be rewarded; I will give them human form. Those who break my laws will be punished and turned to stone & will never to walk the earth again\". Those who broke the law became stone and were turned into mountains and hills and those who were obedient were turned into human form and were each given their own totem of the animal, bird or reptile from when they began. The tribes knew themselves by their totems - kangaroo, emu, carpet snake, and many, many more. So no one would starve, the Rainbow Serpent ruled that no man should eat of his totem, but only of other totems. This way there was food for everyone.\n" +
                "\nThe tribes lived together on the land given to them by the Rainbow Serpent or Mother of Life and knew the land would always be theirs, and no one should ever take it from them.\n" +
                "\n ", "https://www.kullillaart.com.au/assets/images/image12.jpg", 0));

        story.add(new Story (7, "Long ago in the Dreamtime, when the animals were first on the Earth, where they were very much bigger than they are today, there was a time when there was no sun, only a moon and stars. \n" +
                "\nOne day, Dinewan the emu and Brolga the beautiful dancing bird, were out on a large plain arguing and fighting. Brolga got so angry that she ran over to Dinewan's nest and grabbed one of her large eggs, which she threw up into the sky with all her might. It landed on a heap of firewood breaking, spilling the yellow yolk, which burst into flames. This lit up the whole world below to the astonishment of all the creatures as they had only been used to the semi-darkness and were dazzled by such brightness. \n" +
                "\nA good spirit who lived in the sky saw how beautiful the Earth looked when it was lit up by this blaze. He thought it would be a good thing to make a fire every day; and he has done so ever since. All night the good spirit and his helpers collect wood and stack it up. When the stack is nearly big enough, the good spirit sends out the morning star to let them know on Earth that the fire will soon be lit. \n" +
                "\nHowever, the spirits found that sending out the morning star was not enough because those who slept did not see it. The spirits decided they must have a noise made at the dawn of each new day to announce the arrival of the Sun, which would wake the sleepers - but what noise? \n" +
                "\nThen one day the spirits heard the laughter of Goo-Goor-Gaga, the kookaburra ringing through the air. This was the noise the spirits were looking for. They asked Goo-Goor-Gaga that as the morning star faded and the day dawned he laugh his loudest to awaken all the sleepers before sunrise. Goo-Goor-Gaga agreed and has done so ever since - making the air ring with his early morning laughter. \n" +
                "\n ", "https://www.kullillaart.com.au/assets/full/ARTP-GCARD-DKA-KBURRA.jpg?20200711031150", 7));


        return story;
    }



    }
