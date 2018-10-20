package net.jakartaee.tutorials.jee101.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.jakartaee.tutorials.jee101.model.Greeting;

@Path("hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getText() {
        return Response.ok("Hello", MediaType.TEXT_HTML).build();
    }
    
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJSON() {
    	Greeting greeting = new Greeting("Hello", "Mr. Tibbs");
        return Response.ok(greeting, MediaType.APPLICATION_JSON).build();
    }
    
}