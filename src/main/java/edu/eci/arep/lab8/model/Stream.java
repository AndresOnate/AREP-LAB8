package edu.eci.arep.lab8.model;

import java.util.List;

public class Stream {

    private List<Post> stream;

    public String toString() {
        String res = "";
        for (Post post : stream) {
            res += post.getOwner().getUsername() + "\n " + post.getContent() + "\n";
        }
        return res;
    }
}
