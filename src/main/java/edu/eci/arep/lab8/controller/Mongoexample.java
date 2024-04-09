package edu.eci.arep.lab8.controller;

import com.mongodb.client.MongoDatabase;
import edu.eci.arep.lab8.model.Post;

import java.util.Date;


public class Mongoexample {
        public static void main(String[] args) {
            MongoDatabase database = MongoUtil.getDB();
            PostDAO logDAO = new PostDAO(database);
            logDAO.addPost(new Post(null, "Prueba"));
            String jsonLogs = logDAO.listPost();
            System.out.println(jsonLogs);
        }

}
