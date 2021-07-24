package com.example.infs3605.Entities;

import java.util.ArrayList;
import com.example.infs3605.R;

public class Modules {
    private int moduleId;
    private String moduleName;
    private int topicId;
    private String moduleSubtitle;
    private String moduleDescription;
    private String moduleBackgroundImage;

    private Modules (){

    }

    public Modules(int moduleId, String moduleName, String moduleSubtitle, String moduleDescription, String moduleBackgroundImage, int topicId) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleSubtitle = moduleSubtitle;
        this.moduleDescription = moduleDescription;
        this.moduleBackgroundImage = moduleBackgroundImage;
        this.topicId = topicId;
    }


    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getModuleSubtitle() {
        return moduleSubtitle;
    }

    public void setModuleSubtitle(String moduleSubtitle) {
        this.moduleSubtitle = moduleSubtitle;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public String getModuleBackgroundImage() {
        return moduleBackgroundImage;
    }

    public void setModuleBackgroundImage(String moduleBackgroundImage) {
        this.moduleBackgroundImage = moduleBackgroundImage;
    }

    public static ArrayList<Modules> getModules() {
        ArrayList<Modules> modules = new ArrayList<>();

        modules.add(new Modules(0, "The Rainbow Serpent", "The meaning of art","This module will cover the importance of Indigenous art through the tale of The Rainbow Serpent. The Rainbow Serpent or Rainbow Snake is creator of human beings. It has life-\u200Bgiving powers that send conception (fertility) spirits to all the watercourses, such as billabongs, rivers, creeks and lagoons as it is in control of producing rainfall.", "https://d2gf0xft9fx5vk.cloudfront.net/Images/Activities/Activity_Image_4324.jpg", 0));
        modules.add(new Modules(1, "Tiddalik the Frog", "Corroborees, smoking ceremonies, body art","Tiddalik is a mischievous and very thirsty frog who appears in one of Australia's best known Creation Stories. It's the story of a frog whose greed results in all of the water in the creeks, lakes and rivers being depleted, resulting in the other animals working together to see it returned.\n" +
                "\nIn this module, you will also learn about the importance of traditional rituals and ceremonies.",  "https://www.kullillaart.com.au/assets/full/ARTP-GCARD-DKA-FROG.jpg?20200711031150", 2));
        modules.add(new Modules(7, "Goo-Goor-Gaga the Kookaburra", "Music & Dance, Ceremonies","This module begins by exploring the tale of Goo-Goor-Gaga the Kookaburra. Next, we will learn about the use of music, dance, and ceremonies in Aboriginal culture.",  "https://www.kullillaart.com.au/assets/images/turtle.jpg", 0));
        modules.add(new Modules(6, "Wayambeh the Turtle", "Walpiri language","In this module you will learn about the importance of First Nations language, specifically the Walpiri language, through the tale of Wayambeh the very stubborn turtle.",  "https://www.kullillaart.com.au/assets/images/Kookaburra.jpg", 3));
        modules.add(new Modules(4, "Dadirri - Deep Listening", "Aboriginal meditation","In this lesson you will learn about tbe Aboriginal practice of deep listening, an almost spiritual skill, based on respect. Sometimes called 'dadirri', deep listening is inner, quiet, still awareness, and waiting.",  "https://images.squarespace-cdn.com/content/v1/58a25919db29d63c7fae5195/1514803679139-IQ7R0UC4JW3CQPES8XFY/Alf%27s+spot+copy.jpg?format=2500w", 1));
        modules.add(new Modules(5, "Girawu the Goanna", "Spiritual heroes (jin)","Girawu is the story of the goanna wife that brought water out of the mountains and into the Murray-Darling basin. That water source is now called the Murrumbidgee River, which originates in the Snowy Mountains and flows through the Brindabella mountain range and the ACT. The word murrumbidgee means \"big water\" in the Wiradjuri language.\n" +
                "\nIn this module you will learn about the spiritual heroes of the Wirajiduri people through Girawu the Goanna.",  "https://www.aboriginalartstore.com.au/media/18000/goanna_dreaming_3_photo_slideshow.CACHE-1000x1000.jpg", 1));
        modules.add(new Modules(2, "Bunjil the Creator", "The importance of language", "Bunjil is a wedge-tailed eagle who is the creator deity, culture hero, and ancestral being of the Kulin nation. Bunjil created much of south-eastern Australia and the features and animals within it. He also created people, by breathing life into figures moulded from clay. This module explores the importance of language to First Nations People through the tale of Bunjil the Creator.", "https://the-citizen-web-assets-us.s3.us-east-1.amazonaws.com/uploads/2018/02/13195118/166-1.jpg", 3));
        modules.add(new Modules(3, " Guthi-guthi and the Creation of Ngiyaampaa", "Animals and totems", "The creation story of Ngiyaampaa country is about how the spirit ancestor Guthi-guthi came down from the skies to make a special land for people and animals and birds to live in. In this lesson we use the tale of Guthi-guthi to discuss how Aboriginal spirituality is animalistic and totemic.", "https://www.indigenouspeople.net/images/AboriginalArt.jpg", 1));
        return modules;
    }
}
