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
        quiz.add(new Quiz(0, "What is the rainbow snake also known as in the story?", "The giant snake", "The rainbow mother", "A green snake", "Mother of Life", "Mother of Life", 0));
        quiz.add(new Quiz(1, "Which one of these definitions is incorrect?", "Many cultural stories relate to traditional practices around bush survival management and land, water and bush tucker.", "Even if you are not a descendant of a First Nations Person, you can gain the right to paint the traditional art.", "The ownership of the contents of the paintings are so significant that it removes the need for the artist to sign.", "Artists must be entitled to under traditional law as it’s origins represent their land and people.", "Even if you are not a descendant of a First Nations Person, you can gain the right to paint the traditional art.", 0));
        quiz.add(new Quiz(2, "Which of the following statements about First Nations People’s art is MOST true?", "Traditional art can only be painted by the elders.", "Even if you are not a descendant of a First Nations Person, you can gain the right to paint the traditional art.", "Stories behind the art are connected to individuals through family lineages which as groups become custodians for particular parts of cultural events and stories.", "The art itself defines the origin of their groups; anyone is allowed to paint them.", "Stories behind the art are connected to individuals through family lineages which as groups become custodians for particular parts of cultural events and stories.", 0));
        quiz.add(new Quiz(3, "Why is it important to preserve First Nations People’s art?", "First Nations People’s art is used to communicate meaning and ideas about important cultural and spiritual beliefs.", "Indigenous Aboriginal art is highly valued by the contemporary arts industry.", "The art produced by First Nations People is a good source of income for their communities.", "Without their art there cannot be anymore dreamtime stories.", "First Nations People’s art is used to communicate meaning and ideas about important cultural and spiritual beliefs.", 0));

        quiz.add(new Quiz(4, "Which one of these definitions is incorrect?", "A Corroboree is a ceremonial meeting of First Nations People, where they interact with the Dreamtime through music, costume, and dance", "Body art is an ancient tradition that is used only for marriage ceremonies.", "Smoking ceremonies are used to acknowledge ancestors, ward off evil spirits, and heal and cleanse the place and the participants.", "Rituals and ceremonies are intrinsic to the First Nations People’s expression of culture, and their spiritual and mental wellbeing.", "Body art is an ancient tradition that is used only for marriage ceremonies.", 1));
        quiz.add(new Quiz(5, "Which of the following statements about the First Nations People’s culture is the MOST correct?", "First Nations People have a strong connection with and respect for the land, which is conveyed through many of their Rituals and Ceremonies.", "Rituals and Ceremonies aren’t as important today to the modern First Nations’ People", "The Dreamtime is a series of fictional myths that are told to entertain children", "Rituals and Ceremonies are the same across all tribes.", "First Nations People have a strong connection with and respect for the land, which is conveyed through many of their Rituals and Ceremonies.", 1));
        quiz.add(new Quiz(6, "Why is it important to preserve First Nations People’s Rituals and Ceremonies?", "It is essential for First Nations People’s self expression and well being (which encompasses physical, social, emotional, cultural, spiritual and ecological factors)", "The ecological values and worldviews portrayed through Rituals and Ceremonies are very useful and can contribute to increased sustainability.", "Raising awareness and understanding of the significance of them contributes towards a more Reconciled Australia", "All of the above", "All of the above", 1));
        quiz.add(new Quiz(7, "What caused Tiddalick to laugh and spit out all of the water in his mouth?", "The wombat dancing in a circle until he fell over in the dirt.", "The echidna rolling down the bank of the billabong like a bowling ball.", "The snake wiggling and jiggling around in weird positions.", "The kookaburra telling a hilarious story.", "The snake wiggling and jiggling around in weird positions.", 1));

        quiz.add(new Quiz(16, "Why were the female goannas angry with the male goannas?", "They men always expected the females to fetch their own water.", "The men were hiding the secrets about the water source and did not share with the other animals.", "The males never spent quality time with their female partners.", "The male goannas were violent with the other animals.", "The men were hiding the secrets about the water source and did not share with the other animals.", 5));
        quiz.add(new Quiz(17, "What are the spiritual beliefs of the Wandiri people based on?", "Spiritual beliefs were organised around sacred sites connected to heros known as jin.", "The story about the Girawu The Goanna", "The spiritual bond and connection with people in the community.", "Respect and responsibility for the older generation.", "Spiritual beliefs were organised around sacred sites connected to heros known as jin.", 5));
        quiz.add(new Quiz(18, "Which of the following is the most correct about the Jin?", "The Jin provides teachings and guidance for the Wandiri people.", "Wandiri people can only eat the animal connected to their Jin.", "Each is connected to an animal or plant and each person inherits their jin from their mother and is then responsible for caring for the sacred sites associated with the jin.", "There are 18 or less Wandiri Jins.", "Each is connected to an animal or plant and each person inherits their jin from their mother and is then responsible for caring for the sacred sites associated with the jin.", 5));
        quiz.add(new Quiz(19, "Who in the community is responsible for teaching children about their spiritual beliefs?", "It was the women of the group who were responsible for teaching the very young children.", "It was the men of the group who were responsible for teaching the very young children.", "It was the responsibility of the children to learn by themselves.", "The beliefs and secrets were never passed on to the new generation.", "It was the women of the group who were responsible for teaching the very young children.", 5));

        quiz.add(new Quiz(20, "What did Wayambeh The Turtle do to make the elders of the tribe cross with him?", "Wayambeh disobeyed the elders' rules in marriage and snatched another woman from another tribe.", "Wayambeh disobeyed the elders and went to hunt the Spiny lizards.", "Wayambeh used the sacred shield to protect himself from threat.", "Wayambeh chose to hide from battle against the Spiny lizards.", "Wayambeh disobeyed the elders' rules in marriage and snatched another woman from another tribe.", 6));
        quiz.add(new Quiz(21, "Which of the following statements about First Nations Language is MOST correct?", "In many communities the link between generations of speakers was broken and children had little or no knowledge of their first languages.", "If their language survives, they survive as people", "Being able to pass on language to future generations is central to keeping language, identity and culture strong.", "By drawing on the memories of Elders and historical records, we can not recover the language that is lost.", "By drawing on the memories of Elders and historical records, we can not recover the language that is lost.", 6));
        quiz.add(new Quiz(22, "Which of the following statements about First Nations People MOST true?", "Speaking in language is also a powerful connection to ancestral spirits.", "You can have the stories and knowledge passed down from the elders and even without language our cultural identity can be complete.", "Being able to pass on language to future generations is not central to keeping language, identity and culture strong.", "If language survives so does the Warlpiri people.", "Speaking in language is also a powerful connection to ancestral spirits.", 6));
        quiz.add(new Quiz(23, "Why is it important to preserve the First Nations People language?", "The only way First Nations People will be remembered is from their language.", "Being able to pass on language to future generations is the only way to pass on the dreamtime.", "Being able to pass on language to future generations is central to keeping language, identity and culture strong.", "Preserving the language will keep the elders of the tribe happy.", "Being able to pass on language to future generations is central to keeping language, identity and culture strong.", 6));

        quiz.add(new Quiz(24, "What was the cause for light to shine so brightly for the creatures in the story?", "Brolga threw one of Dinewans eggs into a heapwood of fire.", "Brolga threw one of Dinewans feathers into a heapwood of fire.", "The good spirit who lived in the sky cast down light onto earth.", "Goo-goor-gaga the kookaburra sang and came down light.", "Brolga threw one of Dinewans eggs into a heapwood of fire.", 7));
        quiz.add(new Quiz(25, "Which one of these definitions is incorrect?", "Songlines tell stories of the Creation and Dreamtime as Aboriginals made their journeys across the desert.", "Music and dance are important to Aboriginal culture.", "Music is an integral part of Aboriginal ceremonies, also known as corroborees.", "Music is not used as part of everyday life and to mark special occasions.", "Music is not used as part of everyday life and to mark special occasions.", 7));
        quiz.add(new Quiz(26, "Which of the following statements about the First Nations People’s music is the MOST correct?", "The didgeridoo is the only traditional Aboriginal instrument.", "Music and dance is used as part of everyday life and to mark special occasions.", "It is only through mime and song they tell the mythical history of their tribe.", "Music and dance is not important to Aboriginal culture.", "Music and dance is used as part of everyday life and to mark special occasions.", 7));
        quiz.add(new Quiz(27, "Why is it important to preserve First Nations People’s music?", "Their mythical history is evidenced through their mime and song and should be preserved.", "Because the didgeridoo is the oldest wind instrument.", "To pay respects to Goo-goor--gaga the kookaburra’s morning song.", "Because music and dance are important to Aboriginal culture.", "Their mythical history is evidenced through their mime and song and should be preserved.", 7));

        quiz.add(new Quiz(12, "How did the ancestral spirit Guthi-guthi summon water?", "Casting down lighting upon the mountain to release the water serpent.", "Casting endless rain upon the land.", "The tears of the spirit ancestor poured down to create the oceans.", " Divided the water into parts so that there would be water and air.", "Casting down lighting upon the mountain to release the water serpent.", 3));
        quiz.add(new Quiz(13, "What statement is true about First Nations People’s Spirituality?", "They believe the ancestral being is the father and the son.", "They believe that everything is interconnected, people, plants and animals, landforms and celestial bodies are part of a larger reality.", "Healthy respect for the power of spirit forces is learned only after initiation into adulthood.", "Totems are chosen by the members of the clan as their spiritual emblem?", "They believe that everything is interconnected, people, plants and animals, landforms and celestial bodies are part of a larger reality.", 3));
        quiz.add(new Quiz(14, "Which of the following statements is false?", "Dream time heroes are linked to space and place of the dream time stories.", "Aboriginal cosmogony begins at the ‘Dreamtime’.", "Spiritual forces are believed to have the power to make rain, foster natural growth, assist in hunting and food gathering.", "Humans are of the highest class in nature and are not obligated to treat animals, plants and landforms with respect.", "Humans are of the highest class in nature and are not obligated to treat animals, plants and landforms with respect.", 3));
        quiz.add(new Quiz(15, "Why are the spiritual beliefs of First Nations People important to them?", "They believe humans are on an equal footing with nature; are part of nature and are morally obligated to treat animals, plants and landforms with respect.", "It is a summary of teachings from their spirit answer.", "To spread their beliefs amongst other cultures.", "To only receive blessings from their ancestor by following their beliefs.", "They believe humans are on an equal footing with nature; are part of nature and are morally obligated to treat animals, plants and landforms with respect.", 3));

        quiz.add(new Quiz(8, "What kind of an animal is Bunjil?", "Snake", "Wedge-tailed eagle", "Frog", "Eagle", "Wedge-tailed eagle", 2));
        quiz.add(new Quiz(9, "Which of the following is incorrect?", "Languages are formed from ancestral beings.", "Ancestors taught the language to the first tribe.", "There are more than 250 indigenous languages.", "Passing down the language allows you to pass on cultural knowledge and heritage.", "Languages are formed from ancestral beings.", 2));
        quiz.add(new Quiz(10, "Which of the following statements about Indigenous language is the MOST correct?", "Languages provide a sense of belonging and empowerment to heritage.", "From language First Nations people can hide the secrets of their heritage.", "It is language that defines the origin of the First Nations Person.", "As an outsider speaking the language is forbidden.", "Languages provide a sense of belonging and empowerment to heritage.", 2));
        quiz.add(new Quiz(11, "Why is it important to preserve  language?", "To be able to communicate with the elders.", "To remain unique as First Nations People.", "To pass down cultural knowledge and heritage of their origin to the next generation.", "To understand dream time stories.", "To pass down cultural knowledge and heritage of their origin to the next generation.", 2));

        quiz.add(new Quiz(28, "What is deep listening?", "The practice of listening respectfully", "Processes which encourage people to learn about ancient Aboriginal culture", "A way of building community", "All of the above", "All of the above", 4));
        quiz.add(new Quiz(29, "What is the Wiradjuri word for deep listening?", "Winhangadhurinya", "Dadirri", "Meditation", "None of the above", "Winhangadhurinya", 4));
        quiz.add(new Quiz(30, "What is the best word to describe Dadirri to non-Indigenous people?", "Awareness", "Respect", "Contemplation", "Meditation", "Contemplation", 4));
        quiz.add(new Quiz(31, "How can an individual practise Dadirri?", "By listening to music", "By going outside and listening to the surrounding nature", "By closing your eyes", "By taking a nap", "By going outside and listening to the surrounding nature", 4));

        quiz.add(new Quiz(32, "Why is the community an important aspect of First Nations People's families?", "It is actually not that important", "Community reserves the right to oust you if you look different", "The community is an extension of family", "Because without community there is no family", "The community is an extension of family", 8));
        quiz.add(new Quiz(33, "What is a 'Walkabout'?", "A quick walk around the block", "A quick walk around the burbs", "A period of time which an adolescent male lives away from their social group", "A long walk around the burb", "A period of time which an adolescent male lives away from their social group", 8));
        quiz.add(new Quiz(34, "What is a common way of marking the transition from childhood to adulthood in First Nations People culture?", "When they reach the age of 18", "Through a rite of passage", "When they find a new home", "When they find a mate", "Through a rite of passage", 8));
        quiz.add(new Quiz(35, "What are 'bora' celebrations", "A celebration of the community coming together", "When boys prepare for their next stages of life", "A gathering of different families as one whole community", "When the older males of the community prepare boys for their next stages of life", "When the older males of the community prepare boys for their next stages of life", 8));

        quiz.add(new Quiz(36, "Who created the first human beings?", "The great spirit, Baiame", "The sky spirit, Baiame", "The sky spirit, Balam", "The water spirit, Balam", "The sky spirit, Baiame", 9));
        quiz.add(new Quiz(37, "How does one enter Heaven in First Nations People's culture?", "There is no heaven", "Doing good deeds", "Carrying out the right rituals during life", "To live with honour", "There is no heaven", 9));
        quiz.add(new Quiz(38, "How does one enter 'Land of the Dead' in First Nations People's culture?", "There is no 'Land of the Dead'", "Doing good deeds", "Carrying out the right rituals during life", "To live with honour", "Carrying out the right rituals during life", 9));
        quiz.add(new Quiz(39, "What is death seen as?", "A transitioning phase between adolescence and adulthood", "A transition rite ensuring the continuance of the cycle of life", "A person's relationship with his good deeds", "A person's disconnection with his community", "A transition rite ensuring the continuance of the cycle of life", 9));

        quiz.add(new Quiz(40, "How many seasons are there in the Nyoongar calendar?", "3", "4", "5", "6", "6", 10));
        quiz.add(new Quiz(41, "What is the key message of The Birth of the Butterflies", "Bravery is rewarded as the brave caterpillars become beautiful butterflies after their journey", "Not all things are as ugly as they seem as even butterflies come from caterpillars", "Not to be afraid of setbacks as life gives us an opportunity to transform and find new beauty as we retreat into our homes and cocoons", "Only cockatoos could die in the dreamtime", "Not to be afraid of setbacks as life gives us an opportunity to transform and find new beauty as we retreat into our homes and cocoons", 10));
        quiz.add(new Quiz(42, "What is 'The Dreaming'?", "The images you see as you sleep", "A spiritual world that accompanies our physical one", "Something that is not true", "A goal that one aspires to achieve", "A spiritual world that accompanies our physical one", 10));
        quiz.add(new Quiz(43, "What is one way the First Nations People honour their creators?", "Sing songs about them", "Live their best life with no regrets", "Notice the things around them as signs from their creator", "Give frequent offerings", "Notice the things around them as signs from their creator", 10));

        quiz.add(new Quiz(44, "What animal was Warreem Boofey", "Wombat", "Kangaroo", "Investor", "He was not featured", "He was not featured", 11));
        quiz.add(new Quiz(45, "What animal was Warreen", "Wombat", "Kangaroo", "Investor", "He was not featured", "Wombat", 11));
        quiz.add(new Quiz(46, "What is Aboriginal art about?", "Collective expression", "Self expression", "Collective shared experiences", "Looking good", "Collective shared experiences", 11));
        quiz.add(new Quiz(47, "What type of corroborees excluded outsiders?", "First Nations gathering", "Non-sacred corroborees", "New Years Eve", "Sacred corroborees", "Sacred corroborees", 11));

        return quiz;
    }






    }
