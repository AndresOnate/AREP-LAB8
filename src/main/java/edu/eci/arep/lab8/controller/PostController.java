package edu.eci.arep.lab8.controller;

import edu.eci.arep.lab8.model.Post;
import edu.eci.arep.lab8.service.PostService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.mongodb.client.MongoDatabase;

@Path("/posts")
public class PostController {

    @Inject
    PostService postService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePost(Post post){
        MongoDatabase database = MongoUtil.getDB();
        PostDAO postDAO = new PostDAO(database);
        postDAO.addPost(post);
        return Response.status(201).build();
    }


}
