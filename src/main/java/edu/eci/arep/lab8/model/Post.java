package edu.eci.arep.lab8.model;

public class Post {

    private String userId;
    private String content;

    public Post(String userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public String getOwner() {
        return userId;
    }

    public String getContent() {
        return content;
    }

}
