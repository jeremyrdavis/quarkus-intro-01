package com.redhat.devnexus;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/greeting")
@Produces(MediaType.TEXT_PLAIN)
public class GreetingResource {

    @ConfigProperty(name = "greeting")
    String greeting;

    @GET
    public List<Greeting> greetings() {

        return Greeting.listAll();
    }

    @POST
    @Transactional
    public Greeting addGreeting(String value) {

        Greeting greeting = new Greeting(value);
        greeting.persist();
        return greeting;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Greeting updateGreeting(@PathParam("id")Long id, final String udpatedValue) {

        Greeting greeting = Greeting.findById(id);
        greeting.setValue(udpatedValue);
        greeting.persist();
        return greeting;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteGreeting(@PathParam("id") Long id) {
        Greeting greetingToDelete = Greeting.findById(id);
        greetingToDelete.delete();
        return Response.ok().build();
    }

}