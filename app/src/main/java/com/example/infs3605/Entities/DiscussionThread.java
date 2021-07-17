package com.example.infs3605.Entities;

public class DiscussionThread {
    private String title, author, lastPostTime;
    private int numberOfReplies;

    public DiscussionThread(String title, String author, String lastPostTime, int numberOfReplies) {
        this.title = title;
        this.author = author;
        this.lastPostTime = lastPostTime;
        this.numberOfReplies = numberOfReplies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLastPostTime() {
        return lastPostTime;
    }

    public void setLastPostTime(String lastPostTime) {
        this.lastPostTime = lastPostTime;
    }

    public int getNumberOfReplies() {
        return numberOfReplies;
    }

    public void setNumberOfReplies(int numberOfReplies) {
        this.numberOfReplies = numberOfReplies;
    }
}
