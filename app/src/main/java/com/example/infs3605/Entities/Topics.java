package com.example.infs3605.Entities;

import java.util.ArrayList;

public class Topics {
    private int topicId;
    private String topicName;

    public Topics (){

    }

    public Topics(int topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }



    public static ArrayList<Topics> getTopics() {
        ArrayList<Topics> topics = new ArrayList<>();

        topics.add(new Topics(0, "Arts and Music"));
        topics.add(new Topics(1, "Spirituality"));
        topics.add(new Topics(2, "Rituals and Ceremonies"));
        topics.add(new Topics(3, "Language"));

        return topics;
    }
}
