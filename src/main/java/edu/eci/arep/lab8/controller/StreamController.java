package edu.eci.arep.lab8.controller;

import com.mongodb.client.MongoDatabase;
import edu.eci.arep.lab8.service.PostDAO;
import edu.eci.arep.lab8.util.MongoUtil;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/streams")
public class StreamController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPosts() {
        MongoDatabase database = MongoUtil.getDB();
        PostDAO postDAO = new PostDAO(database);
        return postDAO.listPost();
    }
    
}
