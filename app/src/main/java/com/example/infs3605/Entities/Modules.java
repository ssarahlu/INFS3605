package com.example.infs3605.Entities;

import java.util.ArrayList;
import com.example.infs3605.R;

public class Modules {
    private int moduleId;
    private String moduleName;
    private int topicId;
    private String moduleSubtitle;
    private String moduleDescription;
    private int moduleBackgroundImage;



    private Modules (){

    }

    public Modules(int moduleId, String moduleName, String moduleSubtitle, String moduleDescription, int moduleBackgroundImage, int topicId) {
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

    public int getModuleBackgroundImage() {
        return moduleBackgroundImage;
    }

    public void setModuleBackgroundImage(int moduleBackgroundImage) {
        this.moduleBackgroundImage = moduleBackgroundImage;
    }

    public static ArrayList<Modules> getModules() {
        ArrayList<Modules> modules = new ArrayList<>();

        modules.add(new Modules(0, "The Rainbow Serpent", "The meaning of art","The Rainbow Serpent or Rainbow Snake is creator of human beings. It has life-giving powers that send conception (fertility) spirits to all the watercourses, such as billabongs, rivers, creeks and lagoons as it is in control of producing rainfall.", R.drawable.rainbow_serpent_1, 0));
        modules.add(new Modules(1, "Test 2 The Rainbow Serpent", "2 The meaning of art","Test description 2",  R.drawable.rainbow_serpent_1, 0));

        return modules;
    }
}
