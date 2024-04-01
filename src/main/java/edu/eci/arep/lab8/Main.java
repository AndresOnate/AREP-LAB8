package edu.eci.arep.lab8;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;

import edu.eci.arep.lab8.model.Post;
import edu.eci.arep.lab8.model.Stream;
import edu.eci.arep.lab8.model.User;

@Path("/notTwitter")
@RequestScoped
public class Main {

    private Stream stream = new Stream();

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("stream")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public String stream(@Context SecurityContext ctx) {
        return stream.toJSON();
    }

    @POST
    @Path("addPost")
    @RolesAllowed({ "User", "Admin" })
    @Produces(MediaType.TEXT_PLAIN)
    public String addPost(@Context SecurityContext ctx, Post post) {
        stream.addPost(post);
        return "Post added";
    }

    private String getResponseString(SecurityContext ctx) {
        String name;
        if (ctx.getUserPrincipal() == null) {
            name = "anonymous";
        } else if (!ctx.getUserPrincipal().getName().equals(jwt.getName())) {
            throw new InternalServerErrorException("Principal and JsonWebToken names do not match");
        } else {
            name = ctx.getUserPrincipal().getName();
        }
        return String.format("hello + %s,"
                + " isHttps: %s,"
                + " authScheme: %s,"
                + " hasJWT: %s",
                name, ctx.isSecure(), ctx.getAuthenticationScheme(), hasJwt());
    }

    private boolean hasJwt() {
        return jwt.getClaimNames() != null;
    }
}