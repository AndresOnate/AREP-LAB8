package edu.eci.arep.lab8.model;

public class Post {

    private User owner;
    private String content;

    public Post(User owner, String content) {
        this.owner = owner;
        this.content = content;
    }

    public User getOwner() {
        return owner;
    }

    public String getContent() {
        return content;
    }

}
