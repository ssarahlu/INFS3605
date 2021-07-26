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
        videos.add(new Videos(1, "0y3Ta5xcKV4", 1));
        videos.add(new Videos(2, "kzs78j4IQBw", 2));
        videos.add(new Videos(3, "Agt8BOALb-I", 3));
        videos.add(new Videos(4, "tow2tR_ezL8", 4));
        videos.add(new Videos(5, "tWvoTZxvEs8", 5));
        videos.add(new Videos(6, "DpzDvpZ0hMg", 6));
        videos.add(new Videos(7, "FrKGsnPVRww", 7));
        videos.add(new Videos(8, "lDl5QwAR8DI", 8));
        videos.add(new Videos(9, "OHCJuGlN91s", 9));
        videos.add(new Videos(10, "1MFMpLdKCIM", 10));
        videos.add(new Videos(11, "xDJrnldb08o", 11));

        return videos;
    }



}
