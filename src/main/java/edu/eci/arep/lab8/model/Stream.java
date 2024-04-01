package edu.eci.arep.lab8.model;

import java.util.Iterator;
import java.util.Stack;

public class Stream {

    private Stack<Post> stream;

    public Stream() {
        stream = new Stack<>();
    }

    public void addPost(Post post) {
        stream.push(post);
    }

    public String toJSON() {
        String res = "{";
        Iterator<Post> iterator = stream.iterator();
        // Se extraen los posts y se agregan a una coleccion JSON
        while (iterator.hasNext()) { 
            Post post = iterator.next();
            res += "{\"owner\":\"" + post.getOwner().getUsername() + "\"," +
                        "\"content\":\"" + post.getContent() + "\"},";
        }
        // Se elimina la utlima coma restante --> ...},
        res = res.substring(0, res.length() - 1);
        // Se cierra el JSON
        res += "}";
        return res;
    }
}
