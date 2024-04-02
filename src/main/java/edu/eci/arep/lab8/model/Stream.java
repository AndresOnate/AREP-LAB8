package edu.eci.arep.lab8.model;

import java.util.List;

public class Stream {


    private List<Post> posts;

    public Stream(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


}