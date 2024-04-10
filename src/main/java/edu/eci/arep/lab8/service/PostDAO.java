package edu.eci.arep.lab8.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import edu.eci.arep.lab8.model.Post;
import org.bson.Document;
import com.mongodb.client.FindIterable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PostDAO {

    private final MongoCollection<Document> postsCollection;

    public PostDAO(MongoDatabase database) {
        this.postsCollection = database.getCollection("post");
    }

    public void addPost(Post post) {
        Document newPost = new Document("owner", post.getOwner()).append("content", post.getContent());
        postsCollection.insertOne(newPost);
    }

    public String listPost() {
        FindIterable<Document> posts = postsCollection.find();
        List<String> jsonLogs = new ArrayList<>();
        for (Document post : posts) {
            post.remove("_id");
            jsonLogs.add(post.toJson());
        }
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < jsonLogs.size(); i++) {
            result.append(jsonLogs.get(i));
            if (i < jsonLogs.size() - 1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

}
