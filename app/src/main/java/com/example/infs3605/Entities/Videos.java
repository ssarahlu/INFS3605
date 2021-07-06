package com.example.infs3605.Entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Videos {
    private int videoId;
    private String url;
    private int moduleId;

    public Videos (){

    }

    public Videos(int videoId, String url, int moduleId) {
        this.videoId = videoId;
        this.url = url;
        this.moduleId = moduleId;
    }


    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }


    public static ArrayList<Videos> getVideos() {
        ArrayList<Videos> videos = new ArrayList<>();

        videos.add(new Videos(0, "pCuuRRrfOXo", 0));

        return videos;
    }



}
