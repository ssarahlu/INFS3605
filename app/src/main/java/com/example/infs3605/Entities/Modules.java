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

        modules.add(new Modules(0, "The Rainbow Serpent", "The meaning of art","The Rainbow Serpent or Rainbow Snake is creator of human beings. It has life-giving powers that send conception (fertility) spirits to all the watercourses, such as billabongs, rivers, creeks and lagoons as it is in control of producing rainfall.", "https://www.kullillaart.com.au/assets/images/image12.jpg", 0));
        modules.add(new Modules(1, "Tiddalik the Frog", "Corroborees, smoking ceremonies, body art","Tiddalik is a mischievous and very thirsty frog who appears in one of Australia's best known Creation Stories. It's the story of a frog whose greed results in all of the water in the creeks, lakes and rivers being depleted, resulting in the other animals working together to see it returned.\n" +
                "\n" +
                "In this module, you will also learn about the importance of traditional rituals and ceremonies.",  "https://www.kullillaart.com.au/assets/full/ARTP-GCARD-DKA-FROG.jpg?20200711031150", 2));
        modules.add(new Modules(7, "Goo-Goor-Gaga the Kookaburra", "Music & Dance, Ceremonies","In this module you will learn about different First Nations languages through the tale of Wayambeh the very stubborn turtle.",  "https://www.kullillaart.com.au/assets/images/turtle.jpg", 0));
        modules.add(new Modules(6, "Wayambeh the Turtle", "Walpiri language","In this module you will learn about the importance of First Nations language, specifically the Walpiri language, through the tale of Wayambeh the very stubborn turtle.",  "https://www.kullillaart.com.au/assets/images/Kookaburra.jpg", 3));
        modules.add(new Modules(4, "Dadirri - Deep Listening", "Aboriginal meditation","In this lesson you will learn about tbe Aboriginal practice of deep listening, an almost spiritual skill, based on respect. Sometimes called 'dadirri', deep listening is inner, quiet, still awareness, and waiting.",  "https://www.amnesty.org.au/wp-content/uploads/2018/08/Header-Youth-Network-Dadirri.png", 1));

        return modules;
    }
}
