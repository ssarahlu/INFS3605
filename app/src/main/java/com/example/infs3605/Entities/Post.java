package com.example.infs3605.Entities;

import java.util.Date;

public class Post {
    private String postID, author, authorID, post;
    private Date PostTime;
    private int numStars;

    public Post(String postID, String author, String authorID, String post, Date postDate, int numStars) {
        this.postID = postID;
        this.author = author;
        this.authorID = authorID;
        this.post = post;
        PostTime = postDate;
        this.numStars = numStars;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getPostTime() {
        return PostTime;
    }

    public void setPostTime(Date postTime) {
        PostTime = postTime;
    }

    public int getNumStars() {
        return numStars;
    }

    public void setNumStars(int numStars) {
        this.numStars = numStars;
    }
}
