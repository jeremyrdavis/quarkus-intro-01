package com.redhat.devnexus;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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


}