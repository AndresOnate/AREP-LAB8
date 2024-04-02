package edu.eci.arep.lab8.service;

import java.util.ArrayList;
import java.util.List;

import edu.eci.arep.lab8.model.Post;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostService {

    private static List<Post> DB = new ArrayList<>();

    public List<Post> getPosts(){
        return DB;
    }

    public Post savePost(Post post){
        DB.add(post);
        return post;
    }
}
