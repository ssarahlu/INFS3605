package com.example.infs3605.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"modId", "email"})
public class ProfileData {

    @NonNull
    private int modId;

    @NonNull
    private String email;

    private boolean videoViewed;

    private boolean storyViewed;

    private boolean learningsViewed;

    private boolean quizViewed;

    private int quizStars;

    private int topicId;

    @Ignore
    public ProfileData() {
    }

    public ProfileData(int modId, @NonNull String email, boolean videoViewed, boolean storyViewed, boolean learningsViewed, boolean quizViewed, int quizStars, int topicId) {
        this.modId = modId;
        this.email = email;
        this.videoViewed = videoViewed;
        this.storyViewed = storyViewed;
        this.learningsViewed = learningsViewed;
        this.quizViewed = quizViewed;
        this.quizStars = quizStars;
        this.topicId = topicId;
    }

    public int getModId() {
        return modId;
    }

    public void setModId(int modId) {
        this.modId = modId;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public boolean isVideoViewed() {
        return videoViewed;
    }

    public void setVideoViewed(boolean videoViewed) {
        this.videoViewed = videoViewed;
    }

    public boolean isStoryViewed() {
        return storyViewed;
    }

    public void setStoryViewed(boolean storyViewed) {
        this.storyViewed = storyViewed;
    }

    public boolean isLearningsViewed() {
        return learningsViewed;
    }

    public void setLearningsViewed(boolean learningsViewed) {
        this.learningsViewed = learningsViewed;
    }

    public boolean isQuizViewed() {
        return quizViewed;
    }

    public void setQuizViewed(boolean quizViewed) {
        this.quizViewed = quizViewed;
    }

    public int getQuizStars() {
        return quizStars;
    }

    public void setQuizStars(int quizStars) {
        this.quizStars = quizStars;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
}
