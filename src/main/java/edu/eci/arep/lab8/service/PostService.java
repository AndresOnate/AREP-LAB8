package edu.eci.arep.lab8.service;

import java.util.ArrayList;
import java.util.List;

import edu.eci.arep.lab8.model.Post;
import edu.eci.arep.lab8.model.Stream;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostService {

    private final Stream stream;

    public PostService() {
        this.stream = new Stream();
    }

    /** 
    public static String getAllPosts(){
        String res = "";
        if (!DB.isEmpty()){
            res = "[";
            // Se extraen los posts y se agregan a una coleccion JSON
            for (Post post : DB){
                res += "{\"owner\":\"" + post.getOwner() + "\"," +
                            "\"content\":\"" + post.getContent() + "\"},";
            }
            // Se elimina la utlima coma restante --> ...},
            res = res.substring(0, res.length() - 1);
            // Se cierra el JSON
            res += "]";
        }
        return res;
    }  
    **/  

    public List<Post> getPosts(){
        System.out.println("Get");
        System.out.println(stream.getPosts().toString());
        return stream.getPosts();
    }

    public Post savePost(Post post){
        System.out.println("Save");
        System.out.println(stream.getPosts().toString());
        return stream.add(post);
    }
}
