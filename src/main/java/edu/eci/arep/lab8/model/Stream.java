package edu.eci.arep.lab8.model;

import org.jboss.logging.annotations.Pos;

import java.util.List;

public class Stream {

    public Stream(){}
        private List<Post> posts;

    public Stream(List<Post> posts) {
        this.posts = posts;
    }

    public Post add(Post post){
        posts.add(post);
        return post;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


}