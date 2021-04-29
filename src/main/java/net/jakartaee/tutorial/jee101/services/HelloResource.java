package net.jakartaee.tutorial.jee101.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.jakartaee.tutorial.jee101.model.Greeting;
import net.jakartaee.tutorial.jee101.model.Greeting.VARIANT;

@Path("hello")
public class HelloResource {

    // TODO: Add parameter name with default value
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJSON() {
    	Greeting greeting = new Greeting(VARIANT.HELLO, "Mr.", "Tibbs");
        return Response.ok(greeting, MediaType.APPLICATION_JSON).build();
    }

    
    @Path("/text")    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getText() {
    	Greeting greeting = new Greeting(VARIANT.HELLO, "Mr.", "Tibbs");
       return Response.ok(greeting.toString(), MediaType.TEXT_PLAIN).build();
    }

    
}