package com.alvaroquintana.platzigram.model;

public class Picture {
    private String picture;
    private String username;
    private int time;
    private int numberLikes;

    public Picture(String picture, String username, int time, int numberLikes) {
        this.picture = picture;
        this.username = username;
        this.time = time;
        this.numberLikes = numberLikes;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getNumberLikes() {
        return numberLikes;
    }

    public void setNumberLikes(int numberLikes) {
        this.numberLikes = numberLikes;
    }
}
