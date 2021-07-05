package com.example.infs3605.Entities;

import java.util.ArrayList;

public class Modules {
    private int moduleId;
    private String moduleName;
    private int topicId;

    private Modules (){

    }

    public Modules(int moduleId, String moduleName, int topicId) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
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


    public static ArrayList<Modules> getModules() {
        ArrayList<Modules> modules = new ArrayList<>();

        modules.add(new Modules(1, "The Rainbow Serpent", 1));

        return modules;
    }
}
