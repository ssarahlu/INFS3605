package com.example.infs3605.Entities;

public class Profile {
    private String email, displayName, fname, lname, levelAnimal, levelAnimalIcon;
    private int stars, level;

    public Profile(String email, String displayName, String fname, String lname, String levelAnimal, String levelAnimalIcon, int stars, int level) {
        this.email = email;
        this.displayName = displayName;
        this.fname = fname;
        this.lname = lname;
        this.levelAnimal = levelAnimal;
        this.levelAnimalIcon = levelAnimalIcon;
        this.stars = stars;
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLevelAnimal() {
        return levelAnimal;
    }

    public void setLevelAnimal(String levelAnimal) {
        this.levelAnimal = levelAnimal;
    }

    public String getLevelAnimalIcon() {
        return levelAnimalIcon;
    }

    public void setLevelAnimalIcon(String levelAnimalIcon) {
        this.levelAnimalIcon = levelAnimalIcon;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
