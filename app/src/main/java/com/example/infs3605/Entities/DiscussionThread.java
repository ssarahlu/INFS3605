package com.example.infs3605.Entities;

import java.util.Date;

public class DiscussionThread {
    private String threadID, title, author, authorID, post, fnpReplied;
    private Date lastPostTime, postTime;
    private int numberOfReplies;
    private Boolean arts, culture, values;

    public DiscussionThread(String threadID, String title, String author, String authorID, Date lastPostTime, Date postTime, int numberOfReplies, String post, Boolean arts, Boolean culture, Boolean values, String fnpReplied) {
        this.threadID = threadID;
        this.title = title;
        this.author = author;
        this.authorID = authorID;
        this.lastPostTime = lastPostTime;
        this.postTime = postTime;
        this.numberOfReplies = numberOfReplies;
        this.post = post;
        this.arts = arts;
        this.culture = culture;
        this.values = values;
        this.fnpReplied = fnpReplied;

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

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
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

    public Boolean getArts() {
        return arts;
    }

    public void setArts(Boolean arts) {
        this.arts = arts;
    }

    public Boolean getCulture() {
        return culture;
    }

    public void setCulture(Boolean culture) {
        this.culture = culture;
    }

    public Boolean getValues() {
        return values;
    }

    public void setValues(Boolean values) {
        this.values = values;
    }

    public String getFnpReplied() {
        return fnpReplied;
    }

    public void setFnpReplied(String fnpReplied) {
        this.fnpReplied = fnpReplied;
    }
}
