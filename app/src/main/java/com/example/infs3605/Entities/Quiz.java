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
        quiz.add(new Quiz(18, "Which of the following is the most correct about the Jin?", "The Jin provides teachings and guidance for the Wandiri people.", "Wandiri people can only eat the animal connected to their Jin.", "Each is connected to an animal or plant and each person inherits their jin from their mother and is then responsible for caring for the sacred sites associated with the jin. ", "There are 18 or less Wandiri Jins.", "Spiritual beliefs were organised around sacred sites connected to heros known as jin.", 5));
        quiz.add(new Quiz(19, "Who in the community is responsible for teaching children about their spiritual beliefs?", "It was the women of the group who were responsible for teaching the very young children.", "It was the men of the group who were responsible for teaching the very young children.", "It was the responsibility of the children to learn by themselves.", "The beliefs and secrets were never passed on to the new generation.", "It was the women of the group who were responsible for teaching the very young children.", 5));

        quiz.add(new Quiz(20, "What did Wayambeh The Turtle do to make the elders of the tribe cross with him?", "Wayambeh disobeyed the elders' rules in marriage and snatched another woman from another tribe.", "Wayambeh disobeyed the elders and went to hunt the Spiny lizards.", "Wayambeh used the sacred shield to protect himself from threat.", "Wayambeh chose to hide from battle against the Spiny lizards.", "Wayambeh disobeyed the elders' rules in marriage and snatched another woman from another tribe.", 6));
        quiz.add(new Quiz(21, "Which of the following statements about First Nations Language is MOST correct?", "In many communities the link between generations of speakers was broken and children had little or no knowledge of their first languages.", "If their language survives, they survive as people", "Being able to pass on language to future generations is central to keeping language, identity and culture strong.", "By drawing on the memories of Elders and historical records, we can not recover the language that is lost.", "By drawing on the memories of Elders and historical records, we can not recover the language that is lost.", 6));
        quiz.add(new Quiz(22, "Which of the following statements about First Nations People MOST true?", "Speaking in language is also a powerful connection to ancestral spirits.", "You can have the stories and knowledge passed down from the elders and even without language our cultural identity can be complete.", "Being able to pass on language to future generations is not central to keeping language, identity and culture strong.", "If language survives so does the Warlpiri people.", "Speaking in language is also a powerful connection to ancestral spirits.", 6));
        quiz.add(new Quiz(23, "Why is it important to preserve the First Nations People language?", "The only way First Nations People will be remembered is from their language.", "Being able to pass on language to future generations is the only way to pass on the dreamtime.", "Being able to pass on language to future generations is central to keeping language, identity and culture strong.", "Preserving the language will keep the elders of the tribe happy.", "Being able to pass on language to future generations is central to keeping language, identity and culture strong. ", 6));

        quiz.add(new Quiz(24, "Which of the following statements about First Nations People’s art is MOST true?", "Traditional art can only be painted by the elders.", "Even if you are not a descendant of a First Nations Person, you can gain the right to paint the traditional art.", "Peace and unity", "Stories behind the art are connected to individuals through family lineages which as groups become custodians for particular parts of cultural events and stories.", "The art itself defines the origin of their groups; anyone is allowed to paint them.", 7));
        quiz.add(new Quiz(25, "Which of the following statements about First Nations People’s art is MOST true?", "Traditional art can only be painted by the elders.", "Even if you are not a descendant of a First Nations Person, you can gain the right to paint the traditional art.", "Peace and unity", "Stories behind the art are connected to individuals through family lineages which as groups become custodians for particular parts of cultural events and stories.", "The art itself defines the origin of their groups; anyone is allowed to paint them.", 7));
        quiz.add(new Quiz(26, "Which of the following statements about First Nations People’s art is MOST true?", "Traditional art can only be painted by the elders.", "Even if you are not a descendant of a First Nations Person, you can gain the right to paint the traditional art.", "Peace and unity", "Stories behind the art are connected to individuals through family lineages which as groups become custodians for particular parts of cultural events and stories.", "The art itself defines the origin of their groups; anyone is allowed to paint them.", 7));
        quiz.add(new Quiz(27, "Which of the following statements about First Nations People’s art is MOST true?", "Traditional art can only be painted by the elders.", "Even if you are not a descendant of a First Nations Person, you can gain the right to paint the traditional art.", "Peace and unity", "Stories behind the art are connected to individuals through family lineages which as groups become custodians for particular parts of cultural events and stories.", "The art itself defines the origin of their groups; anyone is allowed to paint them.", 7));

        quiz.add(new Quiz(12, "How did the ancestral spirit Guthi-guthi summon water?", "Casting down lighting upon the mountain to release the water serpent.", "Casting endless rain upon the land.", "The tears of the spirit ancestor poured down to create the oceans.", " Divided the water into parts so that there would be water and air.", "Casting down lighting upon the mountain to release the water serpent.", 3));
        quiz.add(new Quiz(13, "What statement is true about First Nations People’s Spirituality?", "They believe the ancestral being is the father and the son.", "They believe that everything is interconnected, people, plants and animals, landforms and celestial bodies are part of a larger reality.", "Healthy respect for the power of spirit forces is learned only after initiation into adulthood.", "Totems are chosen by the members of the clan as their spiritual emblem?", "They believe that everything is interconnected, people, plants and animals, landforms and celestial bodies are part of a larger reality.", 3));
        quiz.add(new Quiz(14, "Which of the following statements is false?", "Dream time heroes are linked to space and place of the dream time stories.", "Aboriginal cosmogony begins at the ‘Dreamtime’.", "Spiritual forces are believed to have the power to make rain, foster natural growth, assist in hunting and food gathering.", "Humans are of the highest class in nature and are not obligated to treat animals, plants and landforms with respect.", "Humans are of the highest class in nature and are not obligated to treat animals, plants and landforms with respect.", 3));
        quiz.add(new Quiz(15, "Why are the spiritual beliefs of First Nations People important to them?", "They believe humans are on an equal footing with nature; are part of nature and are morally obligated to treat animals, plants and landforms with respect.", "It is a summary of teachings from their spirit answer.", "To spread their beliefs amongst other cultures.", "To only receive blessings from their ancestor by following their beliefs.", "They believe humans are on an equal footing with nature; are part of nature and are morally obligated to treat animals, plants and landforms with respect", 3));

        quiz.add(new Quiz(8, "What kind of an animal is Bunjil?", "Snake", "Wedge-tailed eagle", "Frog", "Eagle", "Wedge-tailed eagle", 2));
        quiz.add(new Quiz(9, "Which of the following is incorrect?", "Languages are formed from ancestral beings.", "Ancestors taught the language to the first tribe.", "There are more than 250 indigenous languages.", "Passing down the language allows you to pass on cultural knowledge and heritage.", "Languages are formed from ancestral beings.", 2));
        quiz.add(new Quiz(10, "Which of the following statements about Indigenous language is the MOST correct?", "Languages provide a sense of belonging and empowerment to heritage.", "From language First Nations people can hide the secrets of their heritage.", "It is language that defines the origin of the First Nations Person.", "As an outsider speaking the language is forbidden.", "Languages provide a sense of belonging and empowerment to heritage.", 2));
        quiz.add(new Quiz(11, "Why is it important to preserve  language?", "To be able to communicate with the elders.", "To remain unique as First Nations People.", "To pass down cultural knowledge and heritage of their origin to the next generation.", "To understand dream time stories.", "To pass down cultural knowledge and heritage of their origin to the next generation.", 2));

        return quiz;
    }






    }
