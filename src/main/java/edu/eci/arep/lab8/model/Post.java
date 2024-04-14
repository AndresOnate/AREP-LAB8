package edu.eci.arep.lab8.model;

public class Post {

    private String owner;
    private String content;

    public Post(){}

    public Post(String owner, String content) {
        this.owner = owner ;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
