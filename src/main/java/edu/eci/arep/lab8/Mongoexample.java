package edu.eci.arep.lab8;

import com.mongodb.client.MongoDatabase;
import edu.eci.arep.lab8.util.MongoUtil;
import edu.eci.arep.lab8.service.PostDAO;
import edu.eci.arep.lab8.model.Post;


public class Mongoexample {
        public static void main(String[] args) {
            MongoDatabase database = MongoUtil.getDB();
            PostDAO logDAO = new PostDAO(database);
            logDAO.addPost(new Post(null, "Prueba"));
            String jsonLogs = logDAO.listPost();
            System.out.println(jsonLogs);
        }

}
