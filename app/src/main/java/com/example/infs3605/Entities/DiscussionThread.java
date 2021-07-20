package com.example.infs3605.Entities;

import java.util.Date;

public class DiscussionThread {
    private String threadID, title, author, authorID, post;
    private Date lastPostTime;
    private int numberOfReplies;

    public DiscussionThread(String threadID, String title, String author, String authorID, Date lastPostTime, int numberOfReplies, String post) {
        this.threadID = threadID;
        this.title = title;
        this.author = author;
        this.authorID = authorID;
        this.lastPostTime = lastPostTime;
        this.numberOfReplies = numberOfReplies;
        this.post = post;
    }

    public String getThreadID() {
        return threadID;
    }

    public void setThreadID(String threadID) {
        this.threadID = threadID;
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

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public Date getLastPostTime() {
        return lastPostTime;
    }

    public void setLastPostTime(Date lastPostTime) {
        this.lastPostTime = lastPostTime;
    }

    public int getNumberOfReplies() {
        return numberOfReplies;
    }

    public void setNumberOfReplies(int numberOfReplies) {
        this.numberOfReplies = numberOfReplies;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
