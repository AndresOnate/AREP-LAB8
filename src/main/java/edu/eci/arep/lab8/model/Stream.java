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

    public String toString() {
        String res = "";
        Iterator<Post> iterator = stream.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            res += post.getOwner().getUsername() + "\n " + post.getContent() + "\n";
        }
        return res;
    }
}
