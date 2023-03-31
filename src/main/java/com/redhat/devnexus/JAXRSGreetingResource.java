package com.redhat.devnexus;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/jaxrsgreeting")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JAXRSGreetingResource {

    @GET
    public Response greetings() {

        return Response.ok().entity(Greeting.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response greeting(@PathParam("id") Long id) {

        return Response.ok().entity(Greeting.findById(id)).build();
    }

    @POST
    @Transactional
    public Response addGreeting(Greeting greetingToAdd) {

        greetingToAdd.persist();
        return Response.created(URI.create("/" + greetingToAdd.id)).entity(greetingToAdd).build();
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
