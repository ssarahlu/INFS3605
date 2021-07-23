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

        story.add(new Story (6, "A long time ago, there lived a man named Wayambeh who was very stubborn and did not listen to his Elders. Every day he did what he wanted to do and did not obey any of the tribal rules. One day, the Elders told Wayambeh that it was time for him to marry a woman from his tribe, but Wayambeh refused to marry the woman who was selected for him. Instead, he grabbed his spear and marched off into the bush to hunt. \n" +
                "\nWhile Wayambeh was hunting, he wrongfully entered another tribe’s territory – this tribe was known as the Spiny Lizards. He saw a woman from the Spiny Lizards who was digging for yams with a digging stick. He decided that she was the woman who he wanted to marry. Wayambeh crept up on the woman like a snake and snatched her from where she was digging. The woman’s name was Ula – she was the princess of the Spiny Lizards. Ula explained to Wayambeh that she was already married with a baby and that she could not marry him because she belonged to the Spiny Lizards. Wayambeh, however, did not listen to Ula, in the same way that he did not listen to his Elders. Instead, he stole Ula from her tribe, and returned to his tribe with her. \n" +
                "\nThe Elders were very cross when they saw Wayambeh with Ula, \"You must return Ula to her tribe immediately\" they demanded. But Wayambeh was again disrespectful and disobedient - he did not return Ula. Wayambeh chose the two biggest shields that he had , one slung on his back and one on his front. As the spears came whizzing through the air, Wayamba drew his arms inside the shields and ducked his head down between them. Shower after shower of weapons they slung at him and they were getting closer so that his only chance to get away was to dive into the creek, and the tribe never saw him again. But in the water hole where he had dived, they saw a strange creature which had a plate fixed on it's back. When they tried to catch the creature, it drew in its head and limbs. So they said, \"It's Wayambeh.\" And this was the beginning of Wayambeh or Turtles, in the creek.", "https://lh3.googleusercontent.com/proxy/hAOcc1oZ0vo6roHPJ2322I6Bo1HAYn3SlL935g3ioqM0Mlg-twvYtCpm7nzdzJGlGxVqSZmYyT10U4CinmAT_leVWZrwlD0ALFTh4oZaIBdMtvb_lf3oqdx8VoeB59Bhj2gOCbJG9lIr", 6));

        story.add(new Story (1, "Once upon a time, a long time ago, in the Dreamtime, lived a frog called Tiddalick.\n" +
                "\nTiddalick was the largest frog in the entire world. One very warm morning, he woke up with feeling very, very thirsty and started to drink the fresh water. He drank and he drank and he kept drinking until all the fresh water in the entire billabong was gone!\n" +
                "\nWhen the other animals arrived at the billabong to get their morning drink, they found it was all dried up. This made them very sad.\n" +
                "\nThey knew Tiddalick the frog had drunk all the water. They knew they needed to come up with a plan to get the water back, but they didn’t know how. They thought and they thought and they thought until they realised that the best way to get the water back was to make Tiddalick laugh. If they could make him laugh then all the water would come spilling out of his mouth and back into the billabong!\n" +
                "\nThe first animal to try and make him laugh was the echidna. She rolled herself up into a tight little ball and rolled down the bank of the billabong like a bowling ball! The kangeroo laughed and so did the emu, but Tiddalick didn’t laugh.The next animal to try and make Tiddalick laugh was the wombat. The wombat stood up on his hind legs and danced around in a circle until he fell over in the dirt! The Galah laughed and so did the goanna, but Tiddalick didn’t laugh.\n" +
                "\nThe next animal to try and make Tiddalick laugh was the kookaburra. She perched herself on a branch close to Tiddalick and told her funniest story. It was so funny that she burst out laughing! But Tiddalick didn’t laugh. He just sat there with his big belly full of all the water.\n" +
                "\nFinally, the snake decided to try and make Tiddalick laugh. She started to dance and dance, wriggling and squirming all over the ground until she eventually tied herself into a knot. The knot was so tight that she struggled and struggled to untie herself but was stuck! Tiddalick watched struggle around, trying to untie herself, and let out a small chuckle. That small chuckle turned into a rumbling in his tummy before it turned into a great big belly laugh! The water came gushing out of his mouth and filled the billabong back up once again.\n" +
                "\nAll the animals jumped with joy as they took big, long, gulps of water to quench their thirst.", "https://lh3.googleusercontent.com/proxy/hAOcc1oZ0vo6roHPJ2322I6Bo1HAYn3SlL935g3ioqM0Mlg-twvYtCpm7nzdzJGlGxVqSZmYyT10U4CinmAT_leVWZrwlD0ALFTh4oZaIBdMtvb_lf3oqdx8VoeB59Bhj2gOCbJG9lIr", 1));

        story.add(new Story (4, "To know me is to breathe with me.\n" +
                "To breathe with me is to listen deeply.\n" +
                "\nTo listen deeply is to connect.\n" +
                "It’s the sound, the sound of deep calling to deep.\n" +
                "\nDadirri, the deep inner spring inside us.\n" +
                "We call on it and it calls on us.\n" +
                "\nWe are river people.\n" +
                "We cannot hurry the river.\n" +
                "We need to move with the current and understand its ways.\n" +
                "We wait for the rain to fill our rivers and water our thirsty.\n" +
                "\nWe watch our bush foods, and wait for them to open before we gather them.\n" +
                "\nWe wait for our young people as they grow.\n" +
                "\nThe time for rebirth is now.\n" +
                "If our culture is alive and strong and respected, it will grow.\n" +
                "It will not die and our spirit will not die.\n" +
                "I believe that the spirit of Dadirri that we have to offer will blossom and grow.\n" +
                "\nNot just within ourselves, but within our whole nation.", "https://www.goodsams.org.au/wp-content/uploads/2019/12/aboriginal-art-503445_1920-940x330.jpg", 4));

        return story;
    }



    }
